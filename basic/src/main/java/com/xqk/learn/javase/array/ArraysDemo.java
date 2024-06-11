package com.xqk.learn.javase.array;

import java.util.Arrays;

/**
 * @author 熊乾坤
 * @since 2021-04-08 14:02
 */
public class ArraysDemo {
    public static void main(String[] args) {
        ArraysDemo arraysDemo = new ArraysDemo();
        arraysDemo.copyOf();
    }

    public void copyOf() {
        Integer[] intArr = {1, 2, 3};
        Object[] longArr = Arrays.copyOf(intArr, 2, Long[].class);
        System.out.println(Arrays.toString(longArr));
    }
}
