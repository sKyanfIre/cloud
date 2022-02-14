package com.zzz.factory;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: ZookeeperFactory
 * 类描述: TODO
 * 创建时间: 2021/12/31 10:16 AM
 * 创建人: zzz
 **/
public class ZookeeperFactory implements Watcher {
   private CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    public void process(WatchedEvent event) {
        if(event.getState() == Event.KeeperState.SyncConnected){
            System.out.println("建立zookeeper连接");
            countDownLatch.countDown();
        }else if(event.getState() == Event.KeeperState.Closed) {
            System.out.println("关闭zookeeper连接");
        }

    }

    public ZooKeeper getInstance() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 2000,  this);
            countDownLatch.await();
            return zooKeeper;


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("建立zookeeper连接失败");
        }
    }
}
