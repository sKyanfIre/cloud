package com.zzz.springmaven.test.bean;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/1/20 2:30 PM
 **/
@Aspect
public class TestAop {

    @Pointcut("@annotation(MyAnno)")
    public void pointCut1() {

    }

    @SneakyThrows
    @Around("pointCut1()")
    public String addLog(ProceedingJoinPoint joinPoint) {
        System.out.println("执行前。。。。");
        String result = (String) joinPoint.proceed();
        System.out.println("执行后。。。。");
        return result;
    }
}
