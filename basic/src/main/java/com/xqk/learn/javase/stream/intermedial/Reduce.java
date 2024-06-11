package com.xqk.learn.javase.stream.intermedial;

import java.util.stream.Stream;

/**
 * 归约
 *
 * @author xiongqiankun
 * @since 2021/11/23 18:48
 */
public class Reduce {
    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3, 4)
                                 .reduce(0, Integer::sum)
                                 .intValue());

        System.out.println(Stream.of(1, 2, 3, 4)
                                 .reduce(Integer::sum)
                                 .orElse(0));
    }
}
