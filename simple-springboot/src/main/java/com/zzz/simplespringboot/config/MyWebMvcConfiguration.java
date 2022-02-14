package com.zzz.simplespringboot.config;

import com.zzz.simplespringboot.filter.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 5:25 PM
 **/
@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {
    @Resource
    private MyHandlerInterceptor myHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor);
    }

}
