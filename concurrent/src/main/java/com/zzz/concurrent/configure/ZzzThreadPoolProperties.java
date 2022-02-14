package com.zzz.concurrent.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 3:35 PM
 **/
@Data
@ConfigurationProperties(prefix = "zzz.threadpool")
public class ZzzThreadPoolProperties {
    private String threadPoolName;
    private int corePoolSize;
    private int maxPoolSize;
    private long timeout;
    private int maxTaskSize;
}
