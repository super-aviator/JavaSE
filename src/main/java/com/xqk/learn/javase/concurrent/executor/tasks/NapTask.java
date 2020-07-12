package com.xqk.learn.javase.concurrent.executor.tasks;

import com.xqk.learn.javase.util.concurrent.Nap;

/**
 * @author 熊乾坤
 * @since 2019-12-20 14:46
 */
public class NapTask implements Runnable {
    private long id;

    public NapTask(long id) {
        this.id = id;
    }


    @Override
    public void run() {
        new Nap(0.2);
        System.out.println(Thread.currentThread().getName() + "[" + id + "]");
    }
}
