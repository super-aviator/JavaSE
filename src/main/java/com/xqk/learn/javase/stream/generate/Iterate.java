package com.xqk.learn.javase.stream.generate;

import java.util.stream.Stream;

/**
 * Stream.iterate() 以种子（第一个参数）开头，并将其传给方法（第二个参数）。
 * 方法的结果将添加到流，并存储作为第一个参数用于下次调用 iterate()，依次类推。
 *
 * @author 熊乾坤
 * @date 2019-9-16
 */
public class Iterate {
    int x = 1;

    Stream<Integer> iterate() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        //skip根据参数丢弃指定数量的流元素。
        Iterate iterate = new Iterate();
        iterate.iterate()
                .skip(20)
                .limit(10)
                .forEach(System.out::println);
    }
}
