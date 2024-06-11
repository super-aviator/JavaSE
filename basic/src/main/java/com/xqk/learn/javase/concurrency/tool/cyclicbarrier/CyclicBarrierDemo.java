package com.xqk.learn.javase.concurrency.tool.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 熊乾坤
 * @since 2021-04-14 18:40
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new PrintBarrierAction());
        for (int i = 0; i < cyclicBarrier.getParties(); i++) {
            Thread thread = new Thread(new SubThread("" + i, cyclicBarrier));
            thread.start();
            if (i == cyclicBarrier.getParties() - 1) {
                thread.interrupt();
            }
        }

    }

    private static class SubThread implements Runnable {
        private final CyclicBarrier cyclicBarrier;
        private final String name;

        private SubThread(String name, CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("thread " + name + " ready!");
                cyclicBarrier.await();
                System.out.println("thread " + name + " done!");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PrintBarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("冲啊！");
        }
    }
}
