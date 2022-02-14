package com.zzz.simplespringboot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/10 2:31 PM
 **/
@Component
public class MySpringRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("zzz's springboot is start complete...");
    }
}
