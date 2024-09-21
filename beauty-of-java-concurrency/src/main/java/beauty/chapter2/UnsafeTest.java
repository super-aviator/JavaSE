package com.xqk.learn.javase.concurrency.TheBeautyOfJavaConcurrency.chapter2;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

/**
 * @author 熊乾坤
 * @since 2020-11-19 8:55
 */
public class UnsafeTest {
    @Test
    public void parkTest() {
        System.out.println("Unsafe park start");
        synchronized (this) {
            Unsafe.getUnsafe().park(false, 1000);
        }
        System.out.println("Unsafe park end");
    }
}
