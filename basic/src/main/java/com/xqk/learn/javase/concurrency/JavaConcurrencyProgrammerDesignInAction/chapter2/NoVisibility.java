package com.xqk.learn.javase.concurrency.JavaConcurrencyProgrammerDesignInAction.chapter2;

/**
 * @author 熊乾坤
 * @since 2021-02-22 20:04
 */
public class NoVisibility {
    private static boolean ready;
    private static long num;

    public static void main(String[] args) throws InterruptedException {
        ReaderThread readerThread = new ReaderThread();
        readerThread.start();
        Thread.sleep(1000);
        num = 99;
        ready = true;
        Thread.sleep(1000);
    }

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(num);
            }
        }
    }
}
