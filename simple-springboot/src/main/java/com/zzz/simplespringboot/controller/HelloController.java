package com.zzz.simplespringboot.controller;

import com.zzz.starter.handler.ZzzTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/9 10:25 AM
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Resource
    private ZzzTemplate zzzTemplate;
    @GetMapping("/ping")
    public String ping() {

        return zzzTemplate.exec();
    }
}
