package com.xqk.learn.javase.netty.demo.tcp;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * NettyClientChannelHandler
 *
 * @author xiongqiankun
 * @since 2022/2/12 20:19
 */
@Slf4j
public class NettyClientInboundChannelHandler extends ChannelInboundHandlerAdapter {
    private static final String EXIT = "exit";
    private final ExecutorService es = Executors.newSingleThreadExecutor();

    /**
     * 当通道就绪就会触发该方法
     */
    @Override

    public void channelActive(ChannelHandlerContext ctx) {
        log.info("ctx:{}", ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Server!", CharsetUtil.UTF_8));
        es.submit(() -> {
            while (true) {
                System.out.print("请输入：");
                var scanner = new Scanner(System.in);
                var input = scanner.nextLine();
                if (EXIT.equals(input.trim()) || !ctx.channel().isOpen()) {
                    ctx.channel().eventLoop().shutdownGracefully();
                    break;
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer(input, CharsetUtil.UTF_8));
            }
        });
        es.shutdown();
    }

    /**
     * 当通道有读取事件时，会触发
     */
    @Override

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        log.info("服务器{}回复的消息 {}", ctx.channel().remoteAddress(), buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("", cause);
        ctx.close();
    }
}
