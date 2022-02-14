package com.zzz.lock;

import com.zzz.factory.ZookeeperFactory;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: MyLock
 * 类描述: TODO
 * 创建时间: 2021/12/31 10:33 AM
 * 创建人: zzz
 **/
public class MyLock implements Watcher {
    private String lockName;
    public static final String LOCK_PATH = "/lock/";
    private ZooKeeper zooKeeper;
    private CountDownLatch countDownLatch;
    private String lockId;
    public MyLock(String lockName) {
        this.lockName = LOCK_PATH + lockName;
        this.countDownLatch = new CountDownLatch(1);
        this.lockId = UUID.randomUUID().toString();

    }
    public void lock(){
        zooKeeper = new ZookeeperFactory().getInstance();
        createLockNode();
    }
    private void createLockNode() {
        try {
            zooKeeper.create(lockName, lockId.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("获取到lock");
        } catch (KeeperException e) {
            try {
                zooKeeper.addWatch(lockName,this, AddWatchMode.PERSISTENT);
                System.out.println("等待lock");
                countDownLatch.await();
                System.out.println("获取到lock");
            } catch (KeeperException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unlock() {
        try {
            zooKeeper.delete(lockName,0);
            System.out.println("释放lock");
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void process(WatchedEvent event) {
        try {
            zooKeeper.create(lockName, lockId.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            countDownLatch.countDown();
        } catch (KeeperException e) {
        } catch (InterruptedException e) {
        }
    }
}
