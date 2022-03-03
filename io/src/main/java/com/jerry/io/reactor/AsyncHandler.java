package com.jerry.io.reactor;

import lombok.extern.slf4j.Slf4j;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/3 7:27 PM
 **/

@Slf4j
public class AsyncHandler extends Handler {
    private final static ExecutorService pool = Executors.newFixedThreadPool(16);

    public AsyncHandler(Selector selector, SocketChannel socketChannel) {
        super(selector, socketChannel);
    }

    @Override
    public void read() {
        doRead();
        pool.submit(new Processor());
    }

    public static class Processor implements Runnable {

        @Override
        public void run() {
            log.info("req is process...");

        }
    }
}
