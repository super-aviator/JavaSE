package com.xqk.learn.javase.concurrency.base;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 熊乾坤
 * @since 2021-05-12 19:22
 */
public class ProducerConsumer {

    private static final Queue<String> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer("生产者");
        Consumer consumer1 = new Consumer("消费者1");
        Consumer consumer2 = new Consumer("消费者2");
        producer.start();
        consumer1.start();
        consumer2.start();

        Thread.currentThread()
              .sleep(3000);
        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
    }

    public static class Producer extends Thread {
        public Producer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (QUEUE) {
                    try {
                        while (QUEUE.size() > 0) {
                            QUEUE.wait();
                        }
                    } catch (Exception ignore) {
                    }
                    QUEUE.add("");
                    System.out.println(Thread.currentThread().getName() + " 生产了一条消息");
                    QUEUE.notifyAll();
                }
            }
            System.out.println(Thread.currentThread()
                                     .getName() + " 退出");
        }
    }

    public static class Consumer extends Thread {

        public Consumer(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (QUEUE) {
                    try {
                        while (QUEUE.size() == 0) {
                            QUEUE.wait();
                        }
                    } catch (Exception ignore) {
                    }
                    QUEUE.poll();
                    System.out.println(Thread.currentThread().getName() + " 消费到一条数据");
                    QUEUE.notifyAll();
                }
            }
            System.out.println(Thread.currentThread()
                                     .getName() + " 退出");
        }
    }
}