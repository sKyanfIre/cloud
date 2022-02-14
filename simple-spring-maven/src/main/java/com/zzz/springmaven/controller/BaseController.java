package com.zzz.springmaven.controller;

import com.zzz.springmaven.model.base.BaseSo;
import com.zzz.springmaven.model.base.PackVo;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName BaseController
 * @description TODO
 * @date 2021/3/5 11:26
 **/
public interface BaseController {

    @GetMapping("/test")
    String test();



    PackVo testString(BaseSo str) ;
}
