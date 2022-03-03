package com.xqk.learn.javase.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * SocketChannel
 *
 * @author xiongqiankun
 * @since 2022/2/11 16:30
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        var sc = SocketChannel.open(new InetSocketAddress("localhost", 9999));
        sc.write(ByteBuffer.wrap("Hello World".getBytes(StandardCharsets.UTF_8)));
        sc.close();
    }
}
