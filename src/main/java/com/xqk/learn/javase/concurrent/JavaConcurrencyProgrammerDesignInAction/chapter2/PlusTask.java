package com.xqk.learn.javase.concurrent.JavaConcurrencyProgrammerDesignInAction.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 熊乾坤
 * @since 2021-02-22 20:10
 */
public class PlusTask implements Runnable {
    private static final AtomicInteger ATOMIC_COUNTER = new AtomicInteger();
    private static int COUNTER;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
        System.out.println("ATOMIC_COUNTER:" + ATOMIC_COUNTER.intValue());
        System.out.println("COUNTER:" + COUNTER);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            ATOMIC_COUNTER.incrementAndGet();
            COUNTER++;
        }
    }
}
