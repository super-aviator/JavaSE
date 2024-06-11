package com.xqk.learn.javase.collection.list;

import java.util.ArrayList;

/**
 * @author 熊乾坤
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(null);
        System.out.println(arrayList.get(0));

        ArrayList list = new ArrayList();
        list.add(1);
        list.add("1");
        System.out.println(list);
    }
}
