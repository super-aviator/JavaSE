package com.xqk.learn.javase.stream.intermedial;

import java.util.stream.Stream;

/**
 * @author xiongqiankun
 * @since 2021/11/23 15:40
 */
public class Distinct {
    public static void main(String[] args) {
        Stream.of("c", "d", "a", "d", "a", "d").distinct().forEach(System.out::println);
    }
}
