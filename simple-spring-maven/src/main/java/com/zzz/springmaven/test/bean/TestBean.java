package com.zzz.springmaven.test.bean;

import lombok.Setter;

import javax.annotation.Resource;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: TestBean
 * 类描述: TODO
 * 创建时间: 2021/12/31 4:00 PM
 * 创建人: zzz
 **/
@Setter
public class TestBean {
    @Resource
    public TestBeanInit testBeanInit;
    @Resource
    public TestBeanDestroy testBeanDestroy;

}
