package com.xqk.learn.javase.algorithm.sort.impl;

import com.xqk.learn.javase.algorithm.sort.interfaces.Sort;

/**
 * 插入排序：从0~p，保证0~p-1位置上的数据是有序的
 * 平均时间复杂度：O(N^2)
 * 最低时间复杂度（数据已有序）：O(N)
 */
public class InsertionSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            for (j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
}
