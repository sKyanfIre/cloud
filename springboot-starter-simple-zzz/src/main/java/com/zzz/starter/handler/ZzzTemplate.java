package com.zzz.starter.handler;

import com.zzz.starter.configuration.DataProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/8 5:11 PM
 **/
@Slf4j
public class ZzzTemplate {
    private final DataProperties dataProperties;
    public ZzzTemplate(DataProperties dataProperties) {
       this.dataProperties = dataProperties;
    }

    public String exec() {
        log.info(dataProperties.toString());
        return dataProperties.toString();
    }
}
