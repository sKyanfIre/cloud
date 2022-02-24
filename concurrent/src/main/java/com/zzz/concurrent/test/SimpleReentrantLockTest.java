package com.zzz.concurrent.test;

import com.zzz.concurrent.juc.SimpleReentrantLock;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhangtianyu
 * @date 2022/2/17 11:59 PM
 **/
@Slf4j
public class SimpleReentrantLockTest {
    @SneakyThrows
    @Test
    public void testSimpleReentrantLock() {
        SimpleReentrantLock lock = new SimpleReentrantLock();
        Thread thread = new Thread(new MyRunner(lock));
        thread.start();
        new Thread(new MyRunner(lock)).start();
        SimpleReentrantLock noFairLock = new SimpleReentrantLock(false);
        new Thread(new MyRunner(noFairLock)).start();
        new Thread(new MyRunner(noFairLock)).start();
        Thread.sleep(20000);

    }


    @SneakyThrows
    @Test
    public void testSimpleCondition() {
        SimpleReentrantLock lock = new SimpleReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        AtomicInteger taskCount = new AtomicInteger(0);
        MyProducer myProducer = new MyProducer(lock, notFull, notEmpty, taskCount);
        Thread thread = new Thread(myProducer);
        thread.start();
        MyConsumer myConsumer = new MyConsumer(lock, notFull, notEmpty, taskCount);
        Thread thread1 = new Thread(myConsumer);
        thread1.start();
        Thread.sleep(60000);
        thread.interrupt();
        thread1.interrupt();
        log.info("produce total {}, consumer total {}", myProducer.getCount(), myConsumer.getCount());
    }

    @Slf4j
    public static class MyProducer implements Runnable {
        private final Lock lock;
        private final Condition notFull;
        private final Condition notEmpty;
        private final AtomicInteger taskCount;
        private static final Integer MAX_TASK_COUNT = 200;
        private Integer count = 0;

        private Integer getCount() {
            return this.count;
        }

        public MyProducer(Lock lock, Condition notFull, Condition notEmpty, AtomicInteger taskCount) {
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
            this.taskCount = taskCount;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (; ; ) {
                lock.lock();
                try {
                    while (taskCount.get() == MAX_TASK_COUNT) {
                        notFull.await();
                    }
                    if (Thread.interrupted()) {
                        return;
                    }
                    taskCount.getAndIncrement();
                    count++;
                    log.info("task count {}, produce task", taskCount.get());
                    notEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    @Slf4j
    public static class MyConsumer implements Runnable {
        private final Lock lock;
        private final Condition notFull;
        private final Condition notEmpty;
        private final AtomicInteger taskCount;
        private Integer count = 0;

        private Integer getCount() {
            return this.count;
        }

        public MyConsumer(Lock lock, Condition notFull, Condition notEmpty, AtomicInteger taskCount) {
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
            this.taskCount = taskCount;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (; ; ) {
                lock.lock();
                try {
                    while (taskCount.get() == 0) {
                        notEmpty.await();
                    }
                    if (Thread.currentThread().isInterrupted() && count == 0) {
                        Thread.interrupted();
                        return;
                    }
                    taskCount.getAndDecrement();
                    count++;
                    log.info("task count {}, consume task", taskCount.get());
                    notFull.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class MyRunner implements Runnable {
        private final SimpleReentrantLock lock;

        public MyRunner(SimpleReentrantLock lock) {
            this.lock = lock;
        }

        @SneakyThrows
        @Override
        public void run() {
            try {
                lock.lock();
                log.info(Thread.currentThread().getName() + " get lock...");
                Thread.sleep(10000L);
                try {
                    lock.lock();
                    log.info(Thread.currentThread().getName() + " get reentrant lock ...");
                } finally {
                    lock.unlock();
                    log.info(Thread.currentThread().getName() + " release lock...");
                }
            } finally {
                lock.unlock();
                log.info(Thread.currentThread().getName() + " release lock...");
            }
        }
    }

    public static class Base {
        protected void testProtected() {
            log.info("base test");
        }
    }

    public static class SimpleBase extends Base {
        protected void testSimpleProtected() {
            testProtected();
        }
    }
}
