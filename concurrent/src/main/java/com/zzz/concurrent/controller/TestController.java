package com.zzz.concurrent.controller;

import com.zzz.concurrent.service.ZzzServiceImpl;
import com.zzz.concurrent.task.ZzzTask;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
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

    @Resource
    private ZzzServiceImpl zzzServiceImpl;

    @Resource(name = "zzzThreadPoolExecutor")
    private ThreadPoolExecutor zzzThreadPoolExecutor;
    private static final ReentrantLock lock = new ReentrantLock();

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

    @GetMapping("lock")
    public String reentrantLock() {
        lock.lock();
        return "lock";
    }

    @GetMapping("/unlock")
    public String unLock() {
        lock.unlock();
        return "unlock";
    }

    @SneakyThrows
    @GetMapping("/setFlag")
    public String setFlag(@PathVariable("flag") String flag) {
        return zzzServiceImpl.setFlag(flag);
    }


}
