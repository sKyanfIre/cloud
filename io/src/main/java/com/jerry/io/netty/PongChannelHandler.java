package com.jerry.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 类描述: TODO
 *
 * @author zhangtianyu
 * @date 2022/3/4 11:40 AM
 **/
@Slf4j
public class PongChannelHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        log.info("receive msg {}", buf.toString(CharsetUtil.US_ASCII));
        ChannelFuture channelFuture = ctx.writeAndFlush(msg);
//        channelFuture.addListener((ChannelFutureListener) future -> ctx.close());
        channelFuture.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("receive msg error, caused by ", cause);
        ctx.close();
    }
}
