package com.xqk.learn.javase.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

/**
 * SelectorTest
 *
 * @author xiongqiankun
 * @since 2022/2/11 15:38
 */
@Slf4j
public class ServerSocketChannelSelectorDemo {
    private static final int PORT = 9999;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private final ByteBuffer msgBuffer;
    private AtomicInteger onlineNumber;


    public ServerSocketChannelSelectorDemo() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            onlineNumber = new AtomicInteger(0);
        } catch (IOException e) {
            log.error("", e);
        }
        msgBuffer = ByteBuffer.allocate(2048);
    }

    public void listen() {
        try {
            while (true) {
                selector.select((selectionKey) -> {
                    if (selectionKey.isAcceptable()) {
                        var serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                        try {
                            var socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_CONNECT);
                            var onlineMsg = socketChannel.getRemoteAddress().toString() + " 上线了，当前在线人数：" + onlineNumber.incrementAndGet();
                            log.info("{}", onlineMsg);
                            msgBuffer.clear();
                            broadcastMsg(selector, socketChannel, msgBuffer.put(onlineMsg.getBytes()));
                        } catch (IOException e) {
                            log.error("", e);
                        }
                    } else if (selectionKey.isReadable()) {
                        readMsg(selectionKey);
                    } else if (selectionKey.isConnectable()) {
                        var socketChannel = (SocketChannel) selectionKey.channel();
                        try {
                            log.info("收到客户端[{}]的Connect消息", socketChannel.getRemoteAddress());
                            selectionKey.cancel();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, 100);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMsg(SelectionKey selectionKey) {
        var socketChannel = (SocketChannel) selectionKey.channel();
        try {
            //接受消息
            msgBuffer.clear();
            socketChannel.read(msgBuffer);
            msgBuffer.flip();
            byte[] bytes = new byte[msgBuffer.remaining()];
            msgBuffer.get(bytes);
            var msg = new String(bytes);
            var sendMsg = socketChannel.getRemoteAddress() + " :" + msg;
            log.info("{}", sendMsg);
            //消息广播
            msgBuffer.clear();
            msgBuffer.put(sendMsg.getBytes());
            broadcastMsg(selector, socketChannel, msgBuffer);
        } catch (IOException e) {
            try {
                var offlineMsg = socketChannel.getRemoteAddress() + " 下线了，当前在线人数：" + onlineNumber.decrementAndGet();
                log.info("{}", offlineMsg);
                msgBuffer.clear();
                msgBuffer.put(offlineMsg.getBytes());
                broadcastMsg(selector, socketChannel, msgBuffer);
                selectionKey.cancel();
                socketChannel.close();
            } catch (IOException ex) {
                log.error("", ex);
            }
        }
    }

    public static void broadcastMsg(Selector selector, SocketChannel self, ByteBuffer byteBuffer) {
        var keys = selector.keys();
        try {
            for (SelectionKey key : keys) {
                var channel = key.channel();
                if (channel instanceof SocketChannel && key.channel() != self) {
                    byteBuffer.flip();
                    ((SocketChannel) key.channel()).write(byteBuffer);
                }
            }
        } catch (IOException e) {
            log.error("", e);
        }
    }

    public static void main(String[] args) {
        var server = new ServerSocketChannelSelectorDemo();
        server.listen();
    }
}
