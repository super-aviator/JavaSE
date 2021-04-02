package com.xqk.learn.javase.concurrent.JavaConcurrencyProgrammerDesignInAction.chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 熊乾坤
 * @since 2021-02-27 17:24
 */
public class TimeLock implements Runnable {
    private static final ReentrantLock RE_ENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TimeLock());
        Thread t2 = new Thread(new TimeLock());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finished");
    }

    @Override
    public void run() {
        try {
            if (RE_ENTRANT_LOCK.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
                System.out.println(Thread.currentThread().getName() + " finished");
            } else {
                System.out.println(Thread.currentThread().getName() + " try lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
