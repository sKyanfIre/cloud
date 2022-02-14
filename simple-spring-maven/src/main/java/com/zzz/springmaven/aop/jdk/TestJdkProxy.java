package com.zzz.springmaven.aop.jdk;

import java.lang.reflect.Proxy;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/1/24 11:55 PM
 **/
public class TestJdkProxy {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        DynamicProxyTeacher proxy = new DynamicProxyTeacher(new ChineseTeacher());

        Teacher proxyTeacher = (Teacher) Proxy.newProxyInstance(ChineseTeacher.class.getClassLoader(),
                ChineseTeacher.class.getInterfaces(),
                proxy);
        proxyTeacher.teach();
    }
}
