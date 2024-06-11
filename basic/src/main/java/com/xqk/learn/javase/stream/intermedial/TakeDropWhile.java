package com.xqk.learn.javase.stream.intermedial;

import java.util.stream.Stream;

/**
 * 分片
 * <p>
 * Java 9新增的中间操作(Java 11中废弃了。。。)
 * 带短路效果的filter
 * 1. takeWhile方法在遇到第一个false时停止处理，返回所有为true的元素
 * 2. 而dropWhile它会从头开始，丢弃所有谓词结果为 false的元素。一旦遭遇谓词计算的结果为 true，它就停止处理，并返回所有剩余的元素
 * 对于已经排序的流，使用filter会对流中的每个元素应用一遍，而使用takeWhile或者dropWhile则会进行截断
 *
 * @author xiongqiankun
 * @since 2021/11/23 15:44
 */
public class TakeDropWhile {
    public static void main(String[] args) {
        Stream.of("a", "b", "d", "d", "e", "f")
              .forEach(System.out::println);
    }
}
