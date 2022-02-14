package com.zzz.springmaven.test.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/1/20 3:23 PM
 **/


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
}
