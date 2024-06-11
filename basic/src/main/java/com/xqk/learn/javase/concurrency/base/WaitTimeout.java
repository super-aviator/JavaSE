package com.xqk.learn.javase.concurrency.base;

/**
 * wait超时之后啥都不会发生
 *
 * @author 熊乾坤
 * @since 2021-03-01 19:42
 */
public class WaitTimeout {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        synchronized (LOCK) {
            try {
                LOCK.wait(2000);
                System.out.println("timeout");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
