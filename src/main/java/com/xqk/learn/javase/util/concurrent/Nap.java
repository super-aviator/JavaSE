package com.xqk.learn.javase.util.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 使当前线程睡眠一段时间
 *
 * @author 熊乾坤
 * @since 2019-12-20 14:30
 */
@SuppressWarnings("unused")
public class Nap {

    public Nap(double second) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
