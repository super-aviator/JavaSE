package com.xqk.learn.javase.concurrency.tool.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * semaphore
 *
 * @author 熊乾坤
 * @since 2021-03-11 21:31
 */
public class SemaphoreDemo implements Runnable {
    private static final Semaphore semaphore = new Semaphore(5);

    //@Override
    //public void run() {
    //    try {
    //        boolean tryAcquire = semaphore.tryAcquire();
    //        System.out.println(Thread.currentThread().getName() + " :" + tryAcquire);
    //        Thread.sleep(5000);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    } finally {
    //        semaphore.release();
    //    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.execute(new SemaphoreDemo());
        }
        es.shutdown();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(10);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "Done !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
