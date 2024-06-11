package com.xqk.learn.javase.stream.generate;

import java.util.Random;

/**
 * Randoms
 * 通过流，可以使用申明式编程语法来对代码进行编写，可以编写更加通俗易懂的代码
 *
 * @author 熊乾坤
 */
public class Randoms {

    public static void main(String[] args) {
        new Random(47)
                .ints(100, 200)
                .distinct()
                .limit(10)
                .sorted()
                .forEach(System.out::println);
    }
}