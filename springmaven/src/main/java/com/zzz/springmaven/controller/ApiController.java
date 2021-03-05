package com.zzz.springmaven.controller;

import com.zzz.springmaven.anno.ControllerLog;
import com.zzz.springmaven.model.base.BaseSo;
import com.zzz.springmaven.model.base.PackVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ApiController implements BaseController{
    @Override
    public String test(){
        return "test";
    }

    @Override
    @ControllerLog
    @PostMapping("/test/testString")
    public PackVo testString(BaseSo str) {
        return new PackVo("success");
    }
}
