package com.zzz.concurrent.test;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 4:50 PM
 **/
public class CountDownTest {
    @SneakyThrows
    public static void main(String[] args) {
        int cnt = 100;
        CountDownLatch countDownLatch = new CountDownLatch(cnt);
        ExecutorService executorService = Executors.newCachedThreadPool();

        IntStream.range(0, 98).forEach(e -> executorService.submit(() -> {
            System.out.println("exec task " + e);
            countDownLatch.countDown();
        }));
        countDownLatch.await();
        System.out.println("finish task.....");
        executorService.shutdown();

    }
}
