package com.xqk.learn.javase.stream.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Pattern类中新增了splitAsStream方法，用来将字符串分隔之后创建一个流
 * <p>
 * 这里有个限制，整个文件必须存储在内存中；在大多数情况下这并不是什么问题，但是这损失了流操作非常重要的优势：
 * 1. 流“不需要存储”。当然它们需要一些内部存储，但是这只是序列的一小部分，和持有整个序列并不相同。
 * 2. 它们是懒加载计算的。
 *
 * @author 熊乾坤
 * @since 2019/9/16 18:46
 */
public class RegexpStream {
    private String content;

    private RegexpStream(String filePath) {
        try {
            content = Files.lines(Paths.get(filePath)).collect(Collectors.joining(" "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Stream<String> stream() {
        //splitAsStream的参数只能是一个CharSequence
        return Pattern.compile("[ ,.?]+").splitAsStream(content);
    }

    public static void main(String[] args) {
        RegexpStream rs = new RegexpStream("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt");
        rs.stream()
                .forEach(System.out::println);
        rs.stream()
                .skip(2)
                .forEach(System.out::println);
    }
}
