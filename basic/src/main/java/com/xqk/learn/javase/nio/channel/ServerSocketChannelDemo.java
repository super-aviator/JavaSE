package com.xqk.learn.javase.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;

/**
 * ServerSocketChannel
 *
 * @author xiongqiankun
 * @since 2022/2/11 16:30
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        var ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("localhost", 9999));
        var sc = ssc.accept();
        var bb = ByteBuffer.allocate(1024);
        while (sc.read(bb) != -1) {
            System.out.println(new String(bb.array()));
        }
        ssc.close();
    }
}
