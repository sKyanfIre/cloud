package com.zzz.springmaven.service;

import com.zzz.springmaven.base.AbstractController;
import com.zzz.springmaven.config.WhiteUrl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName TestConfig
 * @description TODO
 * @date 2021/3/2 13:31
 **/
@Slf4j
public class TestConfig extends AbstractController {
    @Autowired
    private WhiteUrl whiteUrl;

    @Test
    public void testWhiteConfig() {
        log.info(whiteUrl.getUrl().toString());
    }
}
