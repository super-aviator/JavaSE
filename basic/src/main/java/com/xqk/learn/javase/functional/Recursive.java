package com.xqk.learn.javase.functional;

/**
 * lambda也可以进行递归操作
 *
 * @author 熊乾坤
 * @since 2019-9-16
 */
public class Recursive {
    private RecursiveInterface ri;

    /**
     * 递归的主要宗旨：1. 指定边界，2. 不断推进
     */
    private Recursive() {
        ri = n -> n == 0 ? 0 : n + ri.recursive(n - 1);
    }

    private int execute(int num) {
        return ri.recursive(num);
    }

    public static void main(String[] args) {
        Recursive recursive = new Recursive();
        System.out.println(recursive.execute(5));
        System.out.println(recursive.execute(100));
    }


    @FunctionalInterface
    interface RecursiveInterface {
        /**
         * 函数式方法申明
         *
         * @param i 参数
         * @return int
         */
        int recursive(int i);
    }
}
