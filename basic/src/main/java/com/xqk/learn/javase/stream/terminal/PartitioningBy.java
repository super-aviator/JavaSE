package com.xqk.learn.javase.stream.terminal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Stream流的分区操作
 *
 * @author qiankun.xiong
 * @since 2024/8/25 16:51
 */
public class PartitioningBy {
    public static void main(String[] args) {
        System.out.println(multiGroupingBy());
    }

    /**
     * 分区操作，相当于特殊场景的分组
     */
    public static Map<Boolean, Map<Integer, List<Integer>>> multiGroupingBy() {
        return IntStream.range(1, 10)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i % 2 == 0, Collectors.groupingBy(i -> i % 3 == 0 ? 0 : 1)));
    }
}
