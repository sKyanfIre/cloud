package com.jerry.io.reactor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * 类描述: reactor handle
 *
 * @author zhangtianyu
 * @date 2022/3/3 6:00 PM
 **/
@Slf4j
public class Handler implements Runnable {
    private final Selector selector;
    private final SelectionKey selectionKey;
    private final SocketChannel socketChannel;
    private int state = SelectionKey.OP_READ;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    @SneakyThrows
    public Handler(Selector selector, SocketChannel socketChannel) {
        this.selector = selector;
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        this.selectionKey = socketChannel.register(selector, 0);
        this.selectionKey.attach(this);
        this.selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();

    }

    @SneakyThrows
    @Override
    public void run() {

        if (SelectionKey.OP_READ == state) {
            read();
            state = SelectionKey.OP_WRITE;
            selectionKey.interestOps(SelectionKey.OP_WRITE);
            selector.wakeup();
        } else if (SelectionKey.OP_WRITE == state) {
            write();
            socketChannel.close();
        }
    }

    @SneakyThrows
    private void read() {
        int length;
        StringBuilder sb = new StringBuilder();
        while ((length = socketChannel.read(byteBuffer)) != 0) {
            byteBuffer.flip();
            sb.append(new String(byteBuffer.array(), 0, length));
            byteBuffer.clear();
        }
        log.info("receive msg :{}", sb);

    }

    @SneakyThrows
    private void write() {
        byteBuffer.clear();
        byteBuffer.put("pong".getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

    }
}
