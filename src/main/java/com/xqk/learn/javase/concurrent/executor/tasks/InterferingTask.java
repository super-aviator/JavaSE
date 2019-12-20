package com.xqk.learn.javase.concurrent.executor.tasks;

/**
 * @author 熊乾坤
 * @since 2019-12-20 15:04
 */
public class InterferingTask implements Runnable {
    private static long val;
    private long id;

    public InterferingTask(long id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(Thread.currentThread().getName() + "[" + id + "]" + "-" + val);
    }
}
