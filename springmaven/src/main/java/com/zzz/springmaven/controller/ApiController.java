package com.zzz.springmaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName ApiController
 * @description TODO
 * @date 2021/3/2 17:31
 **/
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
