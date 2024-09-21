package com.xqk.learn.javase.stream.generate;

import java.util.stream.Stream;

/**
 * 无限流
 *
 * @author qiankun.xiong
 * @since 2024/8/24 17:22
 */
public class Generate {
    public static void main(String[] args) {
        generate();
    }

    /**
     * Stream.generate() 生成无限流，通过传入一个Supplier<T>类型的参数，每次调用Supplier.get()方法生成一个新的元素。
     */
    public static void generate() {
        Stream.generate(Math::random)
              .limit(5)
              .forEach(System.out::println);
    }
}
