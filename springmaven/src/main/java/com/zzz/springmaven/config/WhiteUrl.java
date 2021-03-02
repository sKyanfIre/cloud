package com.zzz.springmaven.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName WhiteUrl
 * @description TODO
 * @date 2021/3/2 12:09
 **/
@Component
@ConfigurationProperties(prefix = "secure.white")
@Data
@Profile("!dev")
public class WhiteUrl {
    private List<String> url;
}
