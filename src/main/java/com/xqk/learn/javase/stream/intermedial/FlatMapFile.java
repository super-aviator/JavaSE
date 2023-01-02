package com.xqk.learn.javase.stream.intermedial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 使用文件流的方式读取文件中的行，然后将行按照特殊字符将行分隔为单个字符的字符流，使用flatMap
 * 将多个字符流转换为单个字符流。
 *
 * @author 熊乾坤
 * @since 2019/9/18 9:11
 */
public class FlatMapFile {
    private static final Pattern PATTERN = Pattern.compile("\\s+");

    /**
     * 使用pattern自带的splitAsStream方法将字符串转换为字符流
     *
     * @param filePath 文件路径
     * @return Stream<String>
     * @throws IOException 文件读取错误时抛出
     */
    public static Stream<String> stream(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .flatMap(PATTERN::splitAsStream);
    }

    /**
     * 使用Arrays.stream方法将字符串转换为字符流
     *
     * @param filePath 文件路径
     * @return Stream<String>
     * @throws IOException 文件读取错误时抛出
     */
    public static Stream<String> streamWithArray(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .flatMap(t -> Arrays.stream(t.split("\\s+")));
    }

    public static void main(String[] args) throws IOException {
        stream("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt")
                .limit(4)
                .forEach(System.out::println);
    }
}
