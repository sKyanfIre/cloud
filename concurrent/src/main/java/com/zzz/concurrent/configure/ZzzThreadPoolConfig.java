package com.zzz.concurrent.configure;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 3:03 PM
 **/

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池配置
 */
@Configuration
public class ZzzThreadPoolConfig implements DisposableBean {
    @Bean
    public ZzzThreadPoolProperties getZzzThreadPoolProperties() {
        return new ZzzThreadPoolProperties();
    }

    @Bean("zzzThreadPoolExecutor")
    @ConditionalOnBean(ZzzThreadPoolProperties.class)
    public ThreadPoolExecutor getZzzThreadPoolExecutor(ZzzThreadPoolProperties properties) {
        System.out.println("zzz thread pool init with params[" + properties + "]...");
        return new ThreadPoolExecutor(properties.getCorePoolSize(),
                properties.getMaxPoolSize(),
                properties.getTimeout(),
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(properties.getMaxTaskSize()),
                new ZzzRejectedExecutionHandler()
        );

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("zzzThreadPoolExecutor is destroy...");
        getZzzThreadPoolExecutor(getZzzThreadPoolProperties()).shutdown();

    }

    public static class ZzzRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("任务执行失败" + r);
        }
    }
}
