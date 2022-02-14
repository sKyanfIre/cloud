package com.zzz.starter.handler;

import com.zzz.starter.configuration.DataProperties;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/8 5:11 PM
 **/
public class ZzzTemplate {
    private final DataProperties dataProperties;
    public ZzzTemplate(DataProperties dataProperties) {
       this.dataProperties = dataProperties;
    }

    public String exec() {
        System.out.println(dataProperties.toString());
        return dataProperties.toString();
    }
}
