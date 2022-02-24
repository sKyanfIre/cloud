package com.zzz.concurrent.test;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 5:48 PM
 **/
public class ConditionTest {
    private static AtomicInteger products = new AtomicInteger(0);

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        new Thread(new Consumer(lock, notFull, notEmpty)).start();
        new Thread(new Producer(lock, notFull, notEmpty)).start();

    }

    public static class Producer implements Runnable {
        private ReentrantLock lock;
        private Condition notFull;
        private Condition notEmpty;

        public Producer(ReentrantLock lock, Condition notFull, Condition notEmpty) {
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (; ; ) {

                try {
                    lock.lock();
                    while (products.get() == 100) {
                        System.out.println("product full .......");
                        notFull.await();
                    }
                    System.out.println("product ...");
                    products.getAndIncrement();
                    notEmpty.signalAll();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public static class Consumer implements Runnable {
        private ReentrantLock lock;
        private Condition notFull;
        private Condition notEmpty;

        public Consumer(ReentrantLock lock, Condition notFull, Condition notEmpty) {
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        @SneakyThrows
        @Override
        public void run() {

            for (; ; ) {
                try {
                    lock.lock();
                    while (products.get() == 0) {
                        System.out.println("no product can consumer");
                        notEmpty.await();
                    }
                    products.getAndDecrement();
                    System.out.println("consumer ...");
                    notFull.signalAll();

                } finally {
                    lock.unlock();
                }

            }
        }
    }
}
