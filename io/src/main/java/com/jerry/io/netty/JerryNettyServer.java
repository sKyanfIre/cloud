package com.jerry.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/4 11:17 AM
 **/
@Slf4j
public class JerryNettyServer {
    private int port;

    public JerryNettyServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new JerryNettyServer(11111).run();


    }

    @SneakyThrows
    public void run() {
        EventLoopGroup acceptEventGroup = new NioEventLoopGroup();
        EventLoopGroup handleEventGroup = new NioEventLoopGroup(16);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(acceptEventGroup, handleEventGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new PongChannelHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
            ;
            log.info("jerry netty server is start...");
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            acceptEventGroup.shutdownGracefully();
            handleEventGroup.shutdownGracefully();

        }
    }
}
