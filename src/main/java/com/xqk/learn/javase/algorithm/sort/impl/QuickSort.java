package com.xqk.learn.javase.algorithm.sort.impl;

import com.xqk.learn.javase.algorithm.sort.interfaces.Sort;

/**
 * 快速排序：
 * 平均运行时间：O(NlogN)
 * 最坏运行时间：O(N^2)
 */
public class QuickSort implements Sort<Integer> {
    @Override
    public void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int lo, int hi) {
        //基准条件
        if (hi <= lo) {
            return;
        }

        //不断推进
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private int partition(Integer[] arr, int lo, int hi) {
        //数组切分（使用数组第一个元素进行切分）
        int num = arr[lo], i = lo, j = hi + 1;
        while (true) {
            //内部迭代
            while (arr[++i] <= num) {
                if (i >= hi) {
                    break;
                }
            }
            while (arr[--j] > num) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }
}
