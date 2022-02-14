package com.zzz.springmaven.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/1/24 11:54 PM
 **/
public class DynamicProxyTeacher implements InvocationHandler {
    private ChineseTeacher chineseTeacher;
    public DynamicProxyTeacher(ChineseTeacher chineseTeacher) {
        this.chineseTeacher = chineseTeacher;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始。。。");
        Object result = method.invoke(chineseTeacher, args);
        System.out.println("代理结束。。。");
        return result;
    }
}
