package com.zzz.simplespringboot.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 5:48 PM
 **/
@Component
public class MyInitializeAndDistoryBean implements InitializingBean, DisposableBean {
    @Resource
    private MyBean myBean;

    @Override
    public void destroy() throws Exception {
        System.out.println("MyInitializingBean destorying ...");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyInitializingBean afterPropertiesSet...");

    }
}
