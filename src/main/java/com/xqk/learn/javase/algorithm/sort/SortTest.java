package com.xqk.learn.javase.algorithm.sort;

import com.xqk.learn.javase.algorithm.sort.impl.BubbleSort;
import com.xqk.learn.javase.algorithm.sort.impl.InsertionSort;
import com.xqk.learn.javase.algorithm.sort.impl.SelectionSort;
import com.xqk.learn.javase.algorithm.sort.interfaces.Sort;
import org.junit.jupiter.api.Assertions;

public class SortTest {
    private final Integer[] NUMS={67,1,50,99,4,20,324,23,999};

    private final Sort<Integer> sort;

    public SortTest(Sort<Integer> sort) {
        this.sort = sort;
    }

    public void test(){
        sort.sort(NUMS);
        Assertions.assertTrue(sort.isSorted(NUMS));
    }


    public static void main(String[] args) {
        SortTest test=new SortTest(new InsertionSort());
        SortTest test1=new SortTest(new SelectionSort());
        SortTest test2=new SortTest(new BubbleSort());
        test2.test();
    }
}
