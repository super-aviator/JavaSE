package com.xqk.learn.javase.collection.queue;

import java.util.ArrayDeque;

/**
 * DequeTest
 *
 * @author qiankun.xiong
 * @version 1.0.0
 * @since 2026/1/23 11:11
 */
public class DequeTest {
    public static void main(String[] args) {
        var deque=new ArrayDeque<Integer>();
        deque.push(10);
        deque.push(1);
        deque.push(9);
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }
}
