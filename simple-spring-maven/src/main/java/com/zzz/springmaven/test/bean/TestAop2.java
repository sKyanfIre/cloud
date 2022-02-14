package com.zzz.springmaven.test.bean;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/1/26 11:28 AM
 **/
@Aspect
public class TestAop2 {
    @Pointcut("within(com.zzz.springmaven.controller.*)")
    public void pointcut() {

    }


    @SneakyThrows
    @Around("pointcut()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("aop2 log start...");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("aop2 log end...");
        return result;
    }

    @Before("within(com.zzz.springmaven.controller.AdminController)")
    public void before() {
        System.out.println("aop2 log before....");
    }

}
