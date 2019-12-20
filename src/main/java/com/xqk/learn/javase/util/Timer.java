package com.xqk.learn.javase.util;

import lombok.Data;

/**
 * 用来计时，方便计算程序的运行时间，运行时间从对象创建到调用方法为止
 *
 * @author 熊乾坤
 * @since 2019-12-20 13:11
 */
@Data
@SuppressWarnings("unused")
public class Timer {
    private long startTimeMillis;

    public Timer() {
        startTimeMillis = System.currentTimeMillis();
    }

    public long duration() {
        return System.currentTimeMillis() - startTimeMillis;
    }

    public Double durationWithSecond() {
        return (System.currentTimeMillis() - startTimeMillis) / 1000.0;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "startTimeMillis=" + startTimeMillis +
                '}';
    }
}
