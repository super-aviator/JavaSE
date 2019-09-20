package com.xqk.learn.javase.stream.terminal;

import java.io.IOException;

/**
 * 流的组合
 *
 * @author 熊乾坤
 * @date 2019/9/19 13:35
 */
public class StreamCombination {

    public static void main(String[] args) throws IOException {
        StreamCollect.stream()
                .reduce((a, b) -> a + "*_*" + b)
                .ifPresent(System.out::println);

        StreamCollect.stream()
                .reduce((a, b) -> a.length() > b.length() ? a : b)
                .ifPresent(System.out::println);

        System.out.println(StreamCollect.stream()
                .reduce("default", (a, b) -> a + "*_*" + b));
    }
}
