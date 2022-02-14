package com.zzz.watcher;

import com.zzz.factory.ZookeeperFactory;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: LockNodeWatcher
 * 类描述: TODO
 * 创建时间: 2021/12/31 10:24 AM
 * 创建人: zzz
 **/
public class LockNodeWatcher implements Watcher {
    private String lock;
    @Override
    public void process(WatchedEvent event) {
        System.out.println("收到lockNode----" + lock + "变动");
        ZooKeeper zooKeeper = new ZookeeperFactory().getInstance();
        try {
            zooKeeper.create("/lock/" + lock,
                    "lock".getBytes(StandardCharsets.UTF_8) ,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
