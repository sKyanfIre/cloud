package com.zzz.concurrent.juc;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 类描述: 简单可重入锁
 *
 * @author zhangtianyu
 * @date 2022/2/17 11:43 PM
 **/
public class SimpleReentrantLock implements Lock {
    private final Sync sync;

    public SimpleReentrantLock() {
        this.sync = new FairSync();
    }

    public SimpleReentrantLock(boolean fair) {
        this.sync = fair ? new FairSync() : new NoFairSync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    private abstract static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected abstract boolean tryAcquire(int arg);

        @SneakyThrows
        @Override
        protected boolean tryRelease(int arg) {
            int newState = getState() - arg;
            if (getExclusiveOwnerThread() != Thread.currentThread()) {
                throw new IllegalAccessException();
            }
            boolean release = false;
            if (newState == 0) {
                release = true;
                setExclusiveOwnerThread(null);
            }
            setState(newState);
            return release;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        public Condition newCondition() {
            return new ConditionObject();
        }

    }

    private static class NoFairSync extends Sync {
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == Thread.currentThread()) {
                setState(getState() + arg);
                return true;
            }
            return false;
        }
    }

    private static class FairSync extends Sync {
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state == 0) {
                if (!hasQueuedPredecessors() && compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (getExclusiveOwnerThread() == Thread.currentThread()) {
                return compareAndSetState(getState(), getState() + arg);
            }
            return false;
        }

    }
}
