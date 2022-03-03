package com.xqk.learn.javase.netty.demo.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * TCPServerDemo
 *
 * @author xiongqiankun
 * @since 2022/2/12 19:42
 */
@Slf4j
public class TcpServer {
    private static final int PORT = 9998;

    public static void main(String[] args) {
        // 创建ossGroup和WorkerGroup
        var bossGroup = new NioEventLoopGroup(1);
        var workerGroup = new NioEventLoopGroup();
        try {


            var server = new ServerBootstrap()
                    // 设置BossGroup和WorkerGroup
                    .group(bossGroup, workerGroup)
                    // 设置服务端的channel实现类
                    .channel(NioServerSocketChannel.class)
                    // 设置BossGroup和WorkerGroup的TCP参数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 设置workerGroup的handler
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            log.info("接收到客户端请求：{}", ch.remoteAddress());
                            ch.pipeline().addLast(new NettyServerInboundChannelHandler());
                            log.info("NettyServerChannelHandler添加成功");
                            ch.pipeline().addLast(new NettyServerOutBoundChannelHandler());
                            log.info("NettyServerOutBoundChannelHandler添加成功");
                        }
                    });


            var channelFuture = server.bind(PORT)
                    .sync()
                    .addListener((future) -> {
                        if (future.isSuccess()) {
                            log.info("服务端端口{}绑定成功", PORT);
                        } else {
                            log.info("服务端端口{}绑定失败", PORT);
                        }
                    });

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
