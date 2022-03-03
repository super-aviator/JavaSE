package com.xqk.learn.javase.netty.demo.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * TcpClient
 *
 * @author xiongqiankun
 * @since 2022/2/12 20:15
 */
@Slf4j
public class TcpClient {
    private static final String HOST = "localhost";
    private static final int PORT = 9998;

    public static void main(String[] args) {
        var group = new NioEventLoopGroup(1);
        try {
            var bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new NettyClientInboundChannelHandler());
                            log.info("NettyClientChannelHandler添加成功");
                        }
                    });
            var channelFuture = bootstrap.connect(HOST, PORT).sync();
            channelFuture.addListener((future) -> {
                if (future.isSuccess()) {
                    log.info("{}链接成功", HOST);
                } else {
                    log.info("{}链接失败", HOST);
                }
            });
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }
}
