package com.zzz.simplespringboot.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/11 5:52 PM
 **/

@Component
public class MyFactoryBean implements FactoryBean<MyBean> {
    @Override
    public MyBean getObject() throws Exception {
        System.out.println("MyFactoryBean'getObject() is exec...");
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

}
