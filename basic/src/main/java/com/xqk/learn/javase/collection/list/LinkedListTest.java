package com.xqk.learn.javase.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add(null);
        System.out.println(linkedList.get(0));
    }
}
