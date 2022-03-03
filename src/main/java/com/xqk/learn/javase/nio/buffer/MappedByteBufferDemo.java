package com.xqk.learn.javase.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/**
 * MappedByteBufferDemo
 *
 * @author xiongqiankun
 * @since 2022/2/11 19:08
 */
public class MappedByteBufferDemo {
    public static void main(String[] args) {
        var filePath = Path.of("D:\\Projects\\JavaSE\\src\\main\\java\\com\\xqk\\learn\\javase\\nio\\demo.txt");
        try (var fc = new RandomAccessFile(filePath.toFile(), "rw").getChannel()) {
            var mapByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, 5);
            mapByteBuffer.put((byte) 'L');
            mapByteBuffer.put((byte) 'M');
            mapByteBuffer.put((byte) 'Y');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
