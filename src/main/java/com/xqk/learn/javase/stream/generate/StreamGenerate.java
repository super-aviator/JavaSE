package com.xqk.learn.javase.stream.generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 流的生成，使用Stream或者集合中的方法，生成流
 *
 * @author 熊乾坤
 * @date 2019-9-16
 */
public class StreamGenerate {

    public static void main(String[] args) {
        //通过Stream类的静态方法of进行判断
        Stream<String> stream = Stream.of("Hello my name is xqk , nice to meet you");
        stream.forEach(System.out::println);
        System.out.println("++++++++++++++");

        //通过generate方法，从Supplier接口中获取元素，生成一个流
        Stream<String> stream1 = Stream.generate(() -> "hello");
        stream1.limit(5).forEach(System.out::println);
        System.out.println("++++++++++++++");

        //通过IntStream,LongStream,DoubleStream生成流
        IntStream.range(10, 20).forEach(System.out::println);
        System.out.println(LongStream.range(1000, 2000).sum());
        System.out.println(DoubleStream.of(12.2, 213, 15.432, 234.1234).average().orElseThrow(NoSuchElementException::new));
        System.out.println("++++++++++++++");

        //通过集合的stream方法获得一个流
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.stream()
                .limit(1)
                .forEach(System.out::println);
        System.out.println("++++++++++++++");

        //通过Arrays的stream方法将数组转换为一个流
        Arrays.stream(new String[]{"my", "name", "is", "xqk"})
                .limit(3)
                .skip(1)
                .map(t -> t + " ")
                .forEach(System.out::print);
        //设计流的起始和终止界限
        Arrays.stream(new String[]{"my", "name", "is", "xqk"}, 1, 4)
                .map(t -> t + " ")
                .forEach(System.out::print);
    }
}
