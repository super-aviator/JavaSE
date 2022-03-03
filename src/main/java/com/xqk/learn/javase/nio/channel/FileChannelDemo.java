package com.xqk.learn.javase.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * FileChannelDemo
 *
 * @author xiongqiankun
 * @since 2022/2/11 17:13
 */
public class FileChannelDemo {
    public static void main(String[] args) {
        //写入文件
        var writePath = Path.of("D:\\Projects\\JavaSE\\src\\main\\java\\com\\xqk\\learn\\javase\\nio\\channel\\demo.txt");
        try (var fc = FileChannel.open(writePath, StandardOpenOption.WRITE)) {
            fc.write(ByteBuffer.wrap("Hello World".getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取文件
        var readPath = Path.of("D:\\Projects\\JavaSE\\src\\main\\java\\com\\xqk\\learn\\javase\\English.md");
        try (var fc = FileChannel.open(readPath, StandardOpenOption.READ)) {
            var buffer = ByteBuffer.allocate((int) fc.size());
            fc.read(buffer);
            buffer.flip();
            System.out.print(new String(Arrays.copyOf(buffer.array(), buffer.limit())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
