package com.xqk.learn.javase.stream.terminal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Stream流的分组操作
 *
 * @author qiankun.xiong
 * @since 2024/8/25 16:51
 */
public class GroupingBy {
    public static void main(String[] args) {
        System.out.println(multiGroupingBy());
        System.out.println(multiGroupingByWithCollect());
        System.out.println(multiGroupingByWithProcess());
        System.out.println(multiGroupingByWithMapping());
    }

    /**
     * 多级分组
     */
    public static Map<Integer, Map<Integer, List<Integer>>> multiGroupingBy() {
        return IntStream.range(1, 10)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i % 2 == 0 ? 0 : 1, Collectors.groupingBy(i -> i % 3 == 0 ? 0 : 1)));
    }

    /**
     * 多级分组，对分组后的集合进行收集
     */
    public static Map<Integer, Optional<Integer>> multiGroupingByWithCollect() {
        return IntStream.range(1, 10)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i % 2 == 0 ? 0 : 1, Collectors.maxBy(Integer::compareTo)));
    }

    /**
     * 多级分组，对分组后的集合执行转换函数
     */
    public static Map<Integer, Integer> multiGroupingByWithProcess() {
        return IntStream.range(1, 10)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i % 2 == 0 ? 0 : 1, Collectors.collectingAndThen(Collectors.maxBy(Integer::compareTo), Optional::get)));
    }

    /**
     * 多级分组，对分组后的集合执行映射
     */
    public static Map<Integer, Set<Integer>> multiGroupingByWithMapping() {
        return IntStream.range(1, 10)
                        .boxed()
                        .collect(Collectors.groupingBy(i -> i % 2 == 0 ? 0 : 1, Collectors.mapping(i -> i * i, Collectors.toCollection(TreeSet::new))));
    }
}
