package com.zzz.concurrent.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 类描述: 简单的读写锁
 *
 * @author zhangtianyu
 * @date 2022/2/23 11:26 AM
 **/
public class SimpleReadWriteLock implements ReadWriteLock {
    @Override
    public Lock readLock() {
        return null;
    }

    @Override
    public Lock writeLock() {
        return null;
    }
}
