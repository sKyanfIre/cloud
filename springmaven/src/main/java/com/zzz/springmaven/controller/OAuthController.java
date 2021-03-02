package com.zzz.springmaven.controller;

import com.zzz.springmaven.model.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName OAuthController
 * @description TODO
 * @date 2021/3/2 18:10
 **/
@RestController
@RequestMapping("/oauth")
public class OAuthController {


    @GetMapping("/login")
    public void login( ) {

    }

    @GetMapping("/logout")
    public void logout(){}

    @PostMapping("/register")
    public void register(UserVo userVo) {

    }
}
