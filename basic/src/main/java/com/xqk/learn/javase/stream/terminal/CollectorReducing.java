package com.xqk.learn.javase.stream.terminal;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CollectorReducing
 *
 * @author qiankun.xiong
 * @since 2024/8/25 14:29
 */
public class CollectorReducing {
    public static void main(String[] args) {
        System.out.println(reducingDefault());
    }

    /**
     * 带默认值的collector reducing
     */
    public static Integer reducingDefault() {
        return IntStream.range(0, 10)
                        .boxed()
                        .collect(Collectors.reducing(0, Function.identity(), (a, b) -> Math.max(a, b)));
    }
}
