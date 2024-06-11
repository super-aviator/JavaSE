package com.xqk.learn.javase.stream.generate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Stream也支持builder方法，可以使用add方法动态的向流中添加新的元素,当调用Builder的build方法之后，就不能再向其中添加元素了
 *
 * @author 熊乾坤
 * @since 2019-9-16
 */
public class StreamBuilder {
    private final Stream.Builder<String> builder = Stream.builder();

    private StreamBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath)).forEach(t -> {
            for (String str : t.split("\\s")) {
                builder.add(str);
            }
        });
    }

    private Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        StreamBuilder sb = new StreamBuilder("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt");
        sb.stream()
                .map(t -> t + " ")
                .forEach(System.out::println);
    }
}
