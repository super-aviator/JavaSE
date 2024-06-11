package com.xqk.learn.javase.nio.buffer;

import java.nio.IntBuffer;

/**
 * BufferTest
 *
 * @author xiongqiankun
 * @since 2022/2/11 15:29
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        var buffer = IntBuffer.allocate(5);
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println("position" + buffer.position());
            buffer.put(i);
        }
        //limit表示手动设置的课读取数据极限位置，初始值与capacity相同，可手动设置
        buffer.limit(3);
        //切换为读模式
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        //用完之后需要清理
        buffer.clear();
    }
}
