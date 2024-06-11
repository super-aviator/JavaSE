package com.xqk.learn.javase.stream.terminal;

import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 流的组合,reduce返回的结果为Optional类包装的结果。
 *
 * @author 熊乾坤
 * @since 2019/9/19 13:35
 */
public class StreamCombination {

    public static void main(String[] args) throws IOException {
        //为每个元素之间加上*_*
        StreamCollect.stream()
                .reduce((a, b) -> a + "*_*" + b)
                .ifPresent(System.out::println);

        //查找长度最长的元素
        StreamCollect.stream()
                .reduce((a, b) -> a.length() > b.length() ? a : b)
                .ifPresent(System.out::println);

        //为两个元素之间贾桑*_*，以default开始
        System.out.println(StreamCollect.stream()
                .reduce("default xxx", (a, b) -> a + "*_*" + b));

        OptionalInt oi = Arrays.stream(new int[]{1, 2, 3})
                .reduce((p, l) -> p + l);
        oi.ifPresent(System.out::println);

        //OptionalInt中的getAsInt方法可能会跑异常，需要使用ifPresent进行判断
        oi = Arrays.stream(new int[]{1})
                .reduce((p, l) -> p + l);
        System.out.println(oi.getAsInt());

        System.out.println(Arrays.stream(new int[]{1, 2, 3})
                .summaryStatistics());
    }
}
