package com.zzz.starter.configuration;

import com.zzz.starter.handler.ZzzTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/8 4:54 PM
 **/
@Configuration
public class ZzzAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DataProperties getDataProperties()  {
       return new DataProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public ZzzTemplate getZzzTemplate(DataProperties dataProperties) {
       return new ZzzTemplate(dataProperties);
    }

}
