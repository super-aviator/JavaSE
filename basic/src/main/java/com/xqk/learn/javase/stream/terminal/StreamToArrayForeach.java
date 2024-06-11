package com.xqk.learn.javase.stream.terminal;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 使用toArray方法将流中的元素转换为数组
 * 使用forEach方法消费流中的所有元素
 *
 * @author 熊乾坤
 * @since 2019/9/19 10:55
 */
public class StreamToArrayForeach {
    private static final int[] INTS = new Random().ints(0, 10000).limit(200).toArray();

    private IntStream randIntStream() {
        return IntStream.of(INTS);
    }

    public static void main(String[] args) {
        new StreamToArrayForeach().randIntStream().forEach(t -> System.out.format("%d ", t));
        System.out.println();
        new StreamToArrayForeach().randIntStream().parallel().forEach(t -> System.out.format("%d ", t));
        System.out.println();
        new StreamToArrayForeach().randIntStream().parallel().forEachOrdered(t -> System.out.format("%d ", t));
    }
}
