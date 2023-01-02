package com.xqk.learn.javase.stream.intermedial;

import java.util.stream.LongStream;

import static java.util.stream.LongStream.iterate;
import static java.util.stream.LongStream.rangeClosed;

/**
 * 使用过滤器，对流中的元素进行过滤操作
 *
 * @author 熊乾坤
 * @since 2019/9/16 19:58
 */
public class Filter {
    /**
     * 判断一个数是否是质数的快捷方法：
     * 一个数若可以进行因数分解，那么分解时得到的两个数一定是一个小于等于sqrt(n)，一个大于等于sqrt(n)，
     * 据此，上述在判断时并不需要遍历到n-1，遍历到sqrt(n)即可，因为若sqrt(n)左侧找不到约数，那么右侧也
     * 一定找不到约数。
     * <p>
     * noneMatch方法会对流中的所有元素进行predicate操作，如果所有元素的结果都为false,则返回true，如果
     * 有一个为true,则返回false，noneMatch在遇到错误时会立即返回。
     *
     * @param n 入参
     * @return n是否是质数返回true, 否则返回false
     */
    private static boolean isPrime(final long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    private LongStream getLongStream() {
        return iterate(2, i -> i + 1).filter(Filter::isPrime);
    }

    public static void main(String[] args) {
        new Filter().getLongStream().filter(Filter::isPrime)
                .skip(1)
                .limit(200)
                .forEach(System.out::println);
    }
}
