package com.zzz.springmaven.aspect;

import com.zzz.springmaven.anno.ControllerLog;
import com.zzz.springmaven.model.base.BaseSo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName ControllerLogAspect
 * @description TODO
 * @date 2021/3/5 11:06
 **/
@Aspect
@Slf4j
@Component
public class ControllerLogAspect {

    @Pointcut("execution(* com.zzz.springmaven.controller.BaseController.*(..))")
    public void pointCut(){}

    @Pointcut("execution(* com.zzz.springmaven.controller.T*Controller.*(..))")
    public void afterPointCut(){}
    @Before("pointCut()")
    public void log(){
        log.info("开始请求接口...");
    }

    @After("afterPointCut()")
    public void endLog() {
        log.info("结束请求");
    }

    @Before("within(com.zzz.springmaven.controller.TestController) && args(str)")
    public void endLog2(String str) {
        log.info("请求参数:" + str);
    }
    @Before("execution(* com.zzz.springmaven.controller.T*Controller.*(String)) && args(str)")
    public void before2(String str){
        log.info("before2:" + str);
    }

    @Before("bean(apiController)")
    public void before3() {
        log.info("before3:bean模式");
    }

    @Before("bean(testController) && args(str)")
    public void before4(String str) {
        log.info("before4:bean模式:参数{}",str);
    }

    @Around("@annotation(controllerLog) && args(object)")
    public Object controllerLog( ProceedingJoinPoint joinPoint, ControllerLog controllerLog,BaseSo object) throws Throwable {
        //获取postMapping/getMapping注解
        Object target = joinPoint.getTarget();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        PostMapping post = target.getClass()
                .getDeclaredMethod(signature.getName(), signature.getParameterTypes())
                .getAnnotation(PostMapping.class);
        String url = Stream.of(post)
                .filter(Objects::nonNull)
                .map(e -> {
                    String[] value = e.value();
                    return value[0];
                })
                .findFirst()
                .get();
        log.info("请求接口【{}】开始，请求参数【{}】",url,object.toString());
        Object result = joinPoint.proceed();
        log.info("请求接口【{}】结束，返回报文【{}】",url,result.toString());
        return result;
    }
}
