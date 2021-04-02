package com.xqk.learn.javase.concurrent.TheBeautyOfJavaConcurrency.chapter2;

/**
 * @author 熊乾坤
 * @since 2021-03-19 23:51
 */
public class VolatileReOrder extends Thread {
    private static int num = 0;
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        VolatileReOrder volatileReOrder = new VolatileReOrder();
        volatileReOrder.start();
        SubThread subThread = new SubThread();
        subThread.start();

        Thread.sleep(100);
        volatileReOrder.interrupt();
        System.out.println("exit");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (ready) {
                System.out.println(num + num);
            }
        }
    }

    public static class SubThread extends Thread {
        @Override
        public void run() {
            ready = true;
            num = 2;
        }
    }
}
