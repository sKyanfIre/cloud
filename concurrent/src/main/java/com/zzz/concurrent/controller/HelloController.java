package com.zzz.concurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 4:15 PM
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }

}
