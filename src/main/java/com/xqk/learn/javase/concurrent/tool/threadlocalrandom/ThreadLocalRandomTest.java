package com.xqk.learn.javase.concurrent.tool.threadlocalrandom;

import sun.misc.Contended;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }
    }
}
