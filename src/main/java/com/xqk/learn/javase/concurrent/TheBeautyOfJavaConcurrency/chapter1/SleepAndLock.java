package com.xqk.learn.javase.concurrent.TheBeautyOfJavaConcurrency.chapter1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程调用sleep方法不会释放获得的锁
 *
 * @author 熊乾坤
 * @date 2020-11-16 8:49
 */
public class SleepAndLock {
    /** 可重入锁 */
    public static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();

    }

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            {
                try {
                    SleepAndLock.LOCK.lock();
                    System.out.println("ThreadA lock");
                    System.out.println("ThreadA start sleep");
                    //线程调用sleep方法不会释放获得的锁
                    Thread.sleep(10000);
                    System.out.println("ThreadA end sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SleepAndLock.LOCK.unlock();
                    System.out.println("ThreadA unlock");
                }
            }
        }
    }

    private static class ThreadB extends Thread {
        @Override
        public void run() {
            {
                try {
                    SleepAndLock.LOCK.lock();
                    System.out.println("ThreadB lock");
                    System.out.println("ThreadB start sleep");
                    Thread.sleep(10000);
                    System.out.println("ThreadB end sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SleepAndLock.LOCK.unlock();
                    System.out.println("ThreadB unlock");
                }
            }
        }
    }
}