package com.zzz.springmaven.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName DruidConfiguration
 * @description TODO
 * @date 2021/3/1 18:54
 **/
@Configuration
public class DruidConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource(){
        return new DruidDataSource();
    }
}
