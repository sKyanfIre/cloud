package com.zzz.springmaven.anno;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName ControllerLog
 * @description TODO
 * @date 2021/3/5 13:22
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerLog {

}
