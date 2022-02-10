package com.xqk.learn.javase.stream.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * FileStream
 *
 * @author xiongqiankun
 * @since 2022/1/20 10:53
 */
public class FileStream {
    public static void main(String[] args) {
        long count = 0;
        try (Stream<String> stream = Files.lines(Path.of("D:\\JavaClassPath\\test.txt"))) {
            count = stream.flatMap(line->Arrays.stream(line.split("")))
                          .distinct()
                          .peek(System.out::println)
                          .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
