package com.xqk.learn.javase.concurrency.TheBeautyOfJavaConcurrency.chapter1;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 熊乾坤
 * @since 2020-11-15 16:32
 */
public class ProducerConsumer {
    /** 消息队列 */
    public static final Queue<Long> QUEUE = new LinkedBlockingQueue<>();
    /** 计数器 */
    public static volatile AtomicLong COUNTER = new AtomicLong(0L);

    public static void main(String[] args) {
        Producer producer = new Producer(1);
        Consumer consumer1 = new Consumer(1);
        Consumer consumer2 = new Consumer(2);
        producer.start();
        consumer1.start();
        consumer2.start();
    }

    /**
     * 生产者线程
     */
    private static class Producer extends Thread {
        private final int id;

        public Producer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                //获取QUEUE上的监视器锁
                synchronized (ProducerConsumer.QUEUE) {
                    try {
                        //这里使用while为了防止虚假唤醒
                        while (ProducerConsumer.QUEUE.size() >= 1) {
                            //调用wait方法，会挂起当前线程，同时释放QUEUE上的锁（需要先获取到监视器锁）
                            ProducerConsumer.QUEUE.wait();
                        }
                    } catch (InterruptedException e) {
                        //如果QUEUE的interrupt方法被调用，则wait调用被中断，方法返回
                        e.printStackTrace();
                    }
                    System.out.println("生产者[" + id + "]生产了一条消息" + ProducerConsumer.COUNTER.addAndGet(1));
                    ProducerConsumer.QUEUE.add(ProducerConsumer.COUNTER.get());
                    //通知其他线程（需要获取到监视器锁）
                    ProducerConsumer.QUEUE.notifyAll();
                }
            }
        }
    }

    /**
     * 消费者线程
     */
    private static class Consumer extends Thread {
        private final int id;

        public Consumer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                //获取QUEUE上的监视器锁
                synchronized (ProducerConsumer.QUEUE) {
                    try {
                        //这里使用while为了防止虚假唤醒
                        while (ProducerConsumer.QUEUE.size() < 1) {
                            //调用wait方法，会挂起当前线程，同时释放QUEUE上的锁
                            ProducerConsumer.QUEUE.wait();
                        }
                    } catch (InterruptedException e) {
                        //如果QUEUE的interrupt方法被调用，则wait调用被中断，方法返回
                        e.printStackTrace();
                    }
                    System.out.println("消费者[" + id + "]消费到一条数据" + ProducerConsumer.QUEUE.poll());
                    //通知其他线程（需要获取到监视器锁）
                    ProducerConsumer.QUEUE.notifyAll();
                }
            }
        }
    }
}