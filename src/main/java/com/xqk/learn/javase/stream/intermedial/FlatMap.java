package com.xqk.learn.javase.stream.intermedial;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * flatMap的参数是一个流，他将参数中的所有流中的元素提取出来，形成一个单一的元素，美名其曰：流的扁平化
 * concat函数拼接两个流，将后一个流拼接到前一个流的后面
 *
 * @author 熊乾坤
 * @since 2019/9/17 13:14
 */
public class FlatMap {
    private static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(t -> IntStream.concat(rand.ints(100, 200).limit(t), IntStream.of(-1)))
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5)
                .map(t -> Stream.of(t, t + 1, t + 2))
                .map(t -> t.getClass().getName())
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5)
                .flatMap(t -> Stream.of(t, t + 1, t + 2))
                .peek(t -> System.out.println(t.getClass().getName()))
                .forEach(System.out::println);
    }
}
