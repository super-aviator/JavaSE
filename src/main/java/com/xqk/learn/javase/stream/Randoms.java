package com.xqk.learn.javase.stream;

import java.util.Random;

/**
 * Randoms
 *
 * @author 熊乾坤
 */
public class Randoms {

    public static void main(String[] args) {
        new Random(47)
                .ints(100, 200)
                .limit(10)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}