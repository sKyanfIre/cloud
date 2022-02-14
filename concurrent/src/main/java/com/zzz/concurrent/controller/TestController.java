package com.zzz.concurrent.controller;

import com.zzz.concurrent.task.ZzzTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 3:16 PM
 **/

@RestController
@RequestMapping("/test")
public class TestController {
    public static final String PING = "/ping/{size}";

    @Resource(name = "zzzThreadPoolExecutor")
    private ThreadPoolExecutor zzzThreadPoolExecutor;

    @GetMapping(PING)
    public String ping(@PathVariable("size") Integer size) {
        IntStream.range(0, size).forEach(e -> zzzThreadPoolExecutor.submit(new ZzzTask(e)));
        return String.valueOf(size);
    }

    @GetMapping("/hello")
    public String ping() {
        return "hello";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
