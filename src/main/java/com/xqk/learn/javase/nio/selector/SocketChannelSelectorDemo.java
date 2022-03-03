package com.xqk.learn.javase.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * SocketChannelSelectorDemo
 *
 * @author xiongqiankun
 * @since 2022/2/12 10:31
 */
@Slf4j
public class SocketChannelSelectorDemo {
    private static final int PORT = 9999;
    private final ByteBuffer inputBuffer;
    private final ByteBuffer msgBuffer;
    private Selector selector;
    private SocketChannel socketChannel;

    public SocketChannelSelectorDemo() {
        inputBuffer = ByteBuffer.allocate(2048);
        msgBuffer = ByteBuffer.allocate(1024);
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress("localhost", PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            log.error("", e);
            System.exit(0);
        }
    }

    public void start() {
        var threadPool = Executors.newCachedThreadPool();
        threadPool.execute(() -> {
            try {
                while (true) {
                    selector.select(key -> {
                        if (key.isReadable()) {
                            try {
                                var socketChannel = (SocketChannel) key.channel();
                                if (!socketChannel.isOpen()) {
                                    key.cancel();
                                    socketChannel.close();
                                }
                                //接受消息
                                msgBuffer.clear();
                                socketChannel.read(msgBuffer);
                                msgBuffer.flip();
                                byte[] bytes = new byte[msgBuffer.remaining()];
                                msgBuffer.get(bytes);
                                var msg = new String(bytes);
                                log.info("{}", msg);
                            } catch (IOException e) {
                                log.warn("与服务器断开链接");
                                key.cancel();
                                try {
                                    socketChannel.close();
                                } catch (IOException ex) {
                                    log.error("", ex);
                                }
                            }
                        }
                    }, 100);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();

        while (true) {
            try {
                var scanner = new Scanner(System.in);
                var input = scanner.nextLine();
                if ("exit".equals(input.trim())) {
                    System.exit(0);
                }
                inputBuffer.clear();
                inputBuffer.put(input.getBytes());
                inputBuffer.flip();
                socketChannel.write(inputBuffer);
            } catch (ClosedChannelException closedChannelException) {
                log.error("未连接，请重启服务");
            } catch (IOException e) {
                log.error("", e);
            }
        }
    }

    public static void main(String[] args) {
        var demo = new SocketChannelSelectorDemo();
        demo.start();
    }
}
