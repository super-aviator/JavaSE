package com.xqk.learn.javase.concurrent.base.thread.create;

/**
 * @author 熊乾坤
 * @since 2021-03-13 12:34
 */
public class ImplementsRunnable implements Runnable {
    private final int i;

    public ImplementsRunnable(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementsRunnable(1));
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + i);
    }
}
