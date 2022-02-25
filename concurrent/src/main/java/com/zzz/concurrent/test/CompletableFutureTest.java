package com.zzz.concurrent.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/25 1:54 PM
 **/
public class CompletableFutureTest {
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>(2);
        futures.add(CompletableFuture.runAsync(new MyRunner()));
        futures.add(CompletableFuture.runAsync(new MyRunner()));
    }

    public static class MyRunner implements Runnable {

        @Override
        public void run() {
            System.out.println("{} exec... " +  Thread.currentThread().getName());
        }
    }
}
