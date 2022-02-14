package com.zzz.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 项目名称：IntelliJ IDEA
 * 类名称: TestNodeWatcher
 * 类描述: TODO
 * 创建时间: 2021/12/31 10:13 AM
 * 创建人: zzz
 **/
public class TestNodeWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println("收到testNodeWatcher");

    }
}
