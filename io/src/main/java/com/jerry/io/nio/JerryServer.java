package com.jerry.io.nio;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/3 3:33 PM
 **/
public class JerryServer {
    public static void main(String[] args) {
        new JerryServerInstance().exec();
    }

    @Slf4j
    public static class JerryServerInstance implements Runnable {

        public void exec() {
            run();
        }

        @SneakyThrows
        @Override
        public void run() {
            Selector selector = Selector.open();
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(11111));
            channel.register(selector, SelectionKey.OP_ACCEPT);
            log.info("jerry2.0 is start...");
            for (; ; ) {
                if (selector.select() > 0) {
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

                    while (selectionKeyIterator.hasNext()) {
                        SelectionKey selectKey = selectionKeyIterator.next();

                        if (selectKey.isAcceptable()) {
                            SocketChannel socketChannel = channel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        } else if (selectKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) selectKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            int length;
                            StringBuilder sb = new StringBuilder();
                            while ((length = socketChannel.read(byteBuffer)) != 0) {
                                byteBuffer.flip();
                                sb.append(new String(byteBuffer.array(), 0, length));
                                byteBuffer.clear();
                            }
                            log.info("receive msg :{}", sb);
                            byteBuffer.put("pong".getBytes(StandardCharsets.UTF_8));
                            byteBuffer.flip();
                            socketChannel.write(byteBuffer);
                            socketChannel.close();
                        }
                        selectionKeyIterator.remove();

                    }
                }
            }
        }
    }
}
