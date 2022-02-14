package com.zzz.springmaven.aop.jdk;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/1/24 11:53 PM
 **/
public class ChineseTeacher implements Teacher{
    @Override
    public void teach() {
        System.out.println("语文老师在上课");
    }
}
