package com.xqk.learn.javase.base.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ComparatorTest
 *
 * @author qiankun.xiong
 * @since 2024/9/16 21:21
 */
public class ComparatorTest {
    public static void main(String[] args) {
        natureOrder();
    }

    /**
     * Comparator的naturalOrder方法返回安自然顺序排序的Comparator
     */
    public static void natureOrder() {
        var list = Arrays.asList('c','e','b');
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
