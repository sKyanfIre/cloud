package com.zzz.concurrent.test;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 5:13 PM
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 100).forEach(e -> executorService.submit(new MyRunnable(e, cyclicBarrier)));
        executorService.shutdown();
    }

    public static class MyRunnable implements Runnable {
        private String name;
        private CyclicBarrier cyclicBarrier;

        public MyRunnable(int name, CyclicBarrier cyclicBarrier) {
            this.name = String.valueOf(name);
            this.cyclicBarrier = cyclicBarrier;
        }

        @SneakyThrows
        @Override
        public void run() {

            System.out.println("exec runnable name = " + name);
            Thread.sleep(2000);
            cyclicBarrier.await();
            System.out.println("exec runable name =" + name + " finished...");
        }
    }
}
