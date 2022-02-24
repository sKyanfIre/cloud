package com.zzz.concurrent.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Random;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/18 10:31 AM
 **/
@Service
public class ZzzServiceImpl {
    private String flag;

    @SneakyThrows
    public String setFlag(String flag) {
        flag = flag + new Random().nextInt();
        this.flag = flag;
        Thread.sleep(1000);

        Assert.isTrue(this.flag.equals(flag), "not equal");
        return flag;
    }
}
