package com.zzz.simplespringboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 6:26 PM
 **/

@Component
public class MyAwareBean implements BeanFactoryAware, ApplicationContextAware, EnvironmentAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyAwareBean setBeanFactory is exec");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyAwareBean setApplicationContext is exec");

    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("MyAwareBean setEnvironment is exec");

    }
}
