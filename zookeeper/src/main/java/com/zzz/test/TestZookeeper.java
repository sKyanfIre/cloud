package com.zzz.test;

import com.zzz.lock.MyLock;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: TestZookeeper
 * 类描述: TODO
 * 创建时间: 2021/12/21 3:09 PM
 * 创建人: zzz
 **/
public class TestZookeeper {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        MyLock lock = new MyLock("zzz");
        try{

            lock.lock();
            System.out.println("zzz");
            Thread.sleep(20*1000);
        }finally {
            lock.unlock();
        }

    }
}
