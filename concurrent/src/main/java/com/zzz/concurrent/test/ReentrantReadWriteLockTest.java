package com.zzz.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/2/14 5:36 PM
 **/
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ExecutorService executorService = Executors.newFixedThreadPool(100);

    }

    public static class MyReadRunnable implements Runnable {
        private String name;
        private ReentrantReadWriteLock lock;

        public MyReadRunnable(int name, ReentrantReadWriteLock lock) {
            this.name = String.valueOf(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
            try {
                readLock.lock();
                System.out.println("name = " + name + "获取readlock ");

            } finally {
                readLock.unlock();
            }
        }
    }

    public static class MyWriteRunnable implements Runnable {

        @Override
        public void run() {

        }
    }
}
