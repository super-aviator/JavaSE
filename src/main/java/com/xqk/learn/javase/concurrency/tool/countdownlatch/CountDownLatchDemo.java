package com.xqk.learn.javase.concurrency.tool.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 熊乾坤
 * @since 2021-03-26 0:28
 */
public class CountDownLatchDemo {
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new SubThread1());
        es.execute(new SubThread2());
        COUNT_DOWN_LATCH.await();
        System.out.println("done!");
        es.shutdown();
    }

    private static class SubThread1 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                System.out.println("sub thread1 done!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                COUNT_DOWN_LATCH.countDown();
            }
        }
    }

    private static class SubThread2 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                System.out.println("sub thread2 done!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                COUNT_DOWN_LATCH.countDown();
            }
        }
    }
}
