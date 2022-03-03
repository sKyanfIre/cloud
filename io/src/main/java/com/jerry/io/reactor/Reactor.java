package com.jerry.io.reactor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Objects;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/3 5:45 PM
 **/

@Slf4j
public class Reactor implements Runnable {
    private int port;
    private Selector selector;
    private ServerSocketChannel channel;

    @SneakyThrows
    public Reactor(int port) {
        this.port = port;
        Selector selector = Selector.open();
        this.selector = selector;
        ServerSocketChannel channel = ServerSocketChannel.open();
        this.channel = channel;
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(port));
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Acceptor());

    }

    @SneakyThrows
    @Override
    public void run() {
        log.info("jerry server 3.0 is start...");
        while (!Thread.interrupted()) {
            if (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                    iterator.remove();
                }
            }

        }
        log.info("jerry server 3.0 is exit...");

    }

    public void dispatch(SelectionKey selectionKey) {
        Runnable runnable = (Runnable) selectionKey.attachment();
        if (Objects.nonNull(runnable)) {
            runnable.run();
        }
    }

    private class Acceptor implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            SocketChannel socketChannel = channel.accept();
            new Handler(selector, socketChannel);

        }
    }
}
