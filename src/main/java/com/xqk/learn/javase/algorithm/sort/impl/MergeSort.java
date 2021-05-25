package com.xqk.learn.javase.algorithm.sort.impl;

import com.xqk.learn.javase.algorithm.sort.interfaces.Sort;

/**
 * 归并排序：
 * 最好最差时间复杂度均为：O(NlogN)
 */
public class MergeSort implements Sort<Integer> {
    private Integer[] temp;

    @Override
    public void sort(Integer[] arr) {
        arr = new Integer[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public void sort(Integer[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid - 1);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(Integer[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo, j = mid + 1, c = lo;
        while (i <= mid && j <= hi) {
            if (i > mid) {
                while (j++ <= hi) {
                    arr[c++] = temp[j];
                }
            }
            if (j > hi) {
                while (i++ <= mid) {
                    arr[c++] = temp[i];
                }
            }
            arr[c++] = temp[i].compareTo(temp[j]) > 0 ? temp[j] : temp[i];
        }
    }
}
