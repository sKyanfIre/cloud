package com.zzz.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: TestZookeeprWatcher
 * 类描述: TODO
 * 创建时间: 2021/12/21 6:43 PM
 * 创建人: zzz
 **/
public class TestZookeeprWatcher implements Watcher {
    CountDownLatch countDownLatch;
    public TestZookeeprWatcher(CountDownLatch countDownLatch) {
       this.countDownLatch = countDownLatch;
    }
    @Override
    public void process(WatchedEvent event) {

        if (event.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("建立zookeeper连接");
            countDownLatch.countDown();
        }

    }
}
