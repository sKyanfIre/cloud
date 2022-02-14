package com.zzz.springmaven.test.bean;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: TestBeanDestroy
 * 类描述: TODO
 * 创建时间: 2021/12/31 4:01 PM
 * 创建人: zzz
 **/
public class TestBeanDestroy {

    @MyAnno
    public String test() {
        System.out.println("testBeanDestroy");
        return "testBeanDestroy";
    }
}
