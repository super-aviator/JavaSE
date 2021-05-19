package com.xqk.learn.javase.algorithm.sort.impl;

import com.xqk.learn.javase.algorithm.sort.interfaces.Sort;

/**
 * 冒泡排序：从左到右，将最大的数据冒泡到最右边
 * 平均时间复杂度：O(N^2)
 * 最高时间复杂度：O(N^2)
 */
public class BubbleSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
