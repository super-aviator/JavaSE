package com.xqk.learn.javase.stream.intermedial;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * peek函数用于调试,他可以对中间结果进行消费，接收一个Consumer函数作为参数。
 * 从程序的输出结果中可以看到，流的运行方式为单个元素依次流经下面的所有中间操作。
 * 同时，我们可以了解到必须要有终端操作，流操作才会真正的被执行。
 *
 * @author 熊乾坤
 * @since 2019/9/16 19:01
 */
public class Peeking {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("hello", "woRld", "mY", "nAmE", "Is", "xQk");
        String result = stringStream.skip(1)
                .limit(5)
                .map(t -> t + " ;")
                .peek(t -> System.out.println("t+' '--->" + t))
                .map(String::toUpperCase)
                .peek(t -> System.out.println("t.toUpperCase--->" + t))
                .map(String::toLowerCase)
                .peek(t -> System.out.println("t.toLowerCase--->" + t))
                .collect(Collectors.joining(""));
        System.out.println(result);
    }
}
