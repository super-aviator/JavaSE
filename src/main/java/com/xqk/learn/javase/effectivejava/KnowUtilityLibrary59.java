package com.xqk.learn.javase.effectivejava;

import java.util.concurrent.ThreadLocalRandom;

/**
 * KnowUtilityLibrary59
 * <p>
 * 熟悉常用的类库
 */
public class KnowUtilityLibrary59 {

    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextInt(3));//java7中的ThreadLocalRandom速度比Random类快很多。
    }
}