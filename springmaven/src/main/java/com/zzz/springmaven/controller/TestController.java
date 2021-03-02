package com.zzz.springmaven.controller;

import com.zzz.springmaven.model.UserSo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName TestController
 * @description TODO
 * @date 2021/3/1 16:57
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    public static final String INDEX = "/index";
    public static final String CREATE_INDEX = "/createUser";

    @GetMapping(INDEX)
    public String index(){
        return "index";
    }

    @GetMapping(CREATE_INDEX)
    public String createUser(@Valid  UserSo userSo) {
        log.info(userSo.toString());
        return "success";
    }
}
