package com.zzz.springmaven.controller;

import com.zzz.springmaven.model.so.UserSo;
import com.zzz.springmaven.model.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/testString/{str}")
    public String testString(@PathVariable("str") String str) {
        System.out.println("获取参数" + str);
        return str;
    }

    @PostMapping("/queryUser")
    public UserSo testQueryUser(UserVo userVo) {
        return new UserSo();
    }
}
