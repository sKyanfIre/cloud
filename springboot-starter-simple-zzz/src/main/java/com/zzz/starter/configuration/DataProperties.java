package com.zzz.starter.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/8 5:00 PM
 **/

@Data
@ConfigurationProperties(prefix = "zzz")
public class DataProperties {
    private String host = "https://zzz.com";
    private int port = 80;
    private String username = "zzz";
    private String password = "zzz";
}
