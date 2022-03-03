package com.xqk.learn.javase.netty.demo.tcp;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * NettyServerChannelHandler
 *
 * @author xiongqiankun
 * @since 2022/2/12 20:01
 */
@Slf4j
public class NettyServerInboundChannelHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        log.warn("客户端{}已连接", ctx.channel().remoteAddress());
        ctx.channel()
           .eventLoop()
           .scheduleAtFixedRate(() -> ctx.writeAndFlush(Unpooled.wrappedBuffer("每隔5秒的定时任务".getBytes(StandardCharsets.UTF_8))), 0, 5,
                   TimeUnit.SECONDS);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.warn("客户端{}断开连接", ctx.channel().remoteAddress());
    }

    /**
     * 读取消息
     *
     * @param ctx ChannelHandlerContext
     * @param msg Object
     * @throws Exception Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("服务器读取线程 {} channel {}", Thread.currentThread().getName(), ctx.channel());
        log.info("server ctx {}", ctx);
        log.info("看看channel 和 pipeline的关系");
        Channel channel = ctx.channel();
        // 本质是一个双向链接, 出站入站
        ChannelPipeline pipeline = ctx.pipeline();
        log.info("pipeline {}", pipeline);

        // 将 msg 转成一个 ByteBuf
        // ByteBuf 是 Netty 提供的，不是 NIO 的 ByteBuffer.
        ByteBuf buf = (ByteBuf) msg;
        log.info("客户端{}发送消息是 {}", channel.remoteAddress(), buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 数据读取完毕
     *
     * @param ctx ChannelHandlerContext
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        //write + flush
        ctx.channel()
           .writeAndFlush(Unpooled.wrappedBuffer("Hello Client!".getBytes(CharsetUtil.UTF_8)))
           //完成后关闭对应的channel
           .addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 处理异常，一般关闭通道
     *
     * @param ctx   ChannelHandlerContext
     * @param cause Throwable
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("", cause);
        ctx.close();
    }


}
