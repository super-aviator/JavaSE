package com.xqk.learn.javase.stream.intermedial;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * sorted方法能够对流中的元素进行排序，可以指定一个自定义的比较器，也可以使用Comparator自带的比较器
 *
 * @author 熊乾坤
 * @date 2019/9/16 19:17
 */
public class Sorted {
    public static void main(String[] args) {
        Stream.of("java.util.stream.Stream".split("\\."))
                .map(String::toLowerCase)
                .sorted(Comparator.reverseOrder())
                .map(t -> t + " ")
                .forEach(System.out::print);
        System.out.println();

        Stream.of("java.util.stream.Stream".split("\\."))
                .map(String::toLowerCase)
                .sorted()
                .map(t -> t + " ")
                .forEach(System.out::print);
        System.out.println();

        Stream.of("java.util.stream.Stream".split("\\."))
                .map(String::toLowerCase)
                .sorted((c1, c2) -> c2.compareTo(c1))
                .map(t -> t + " ")
                .forEach(System.out::print);
    }
}
