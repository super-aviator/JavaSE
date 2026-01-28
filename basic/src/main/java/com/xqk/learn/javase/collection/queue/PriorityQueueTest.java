package com.xqk.learn.javase.collection.queue;

import java.util.PriorityQueue;

/**
 * PriorityQueueTest
 *
 * @author qiankun.xiong
 * @version 1.0.0
 * @since 2026/1/23 11:09
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        var priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.offer(10);
        priorityQueue.offer(2);
        priorityQueue.offer(9);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
}
