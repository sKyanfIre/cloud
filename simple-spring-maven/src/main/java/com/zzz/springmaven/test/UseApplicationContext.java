package com.zzz.springmaven.test;

import com.zzz.springmaven.test.bean.TestBean;
import com.zzz.springmaven.test.bean.TestBeanDestroy;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: UseApplicationContext
 * 类描述: TODO
 * 创建时间: 2021/12/31 3:57 PM
 * 创建人: zzz
 **/
public class UseApplicationContext {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.getProperties().put(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "~/github/cloud/springmaven/target");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zzz/github/cloud/springmaven/target");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.testBeanDestroy);
        System.out.println(testBean.testBeanInit);
        TestBeanDestroy testBeanDestroy = context.getBean("testBeanDestroy", TestBeanDestroy.class);
        testBeanDestroy.test();
        System.out.println(testBeanDestroy.getClass());
    }
}
