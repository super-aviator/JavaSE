package com.xqk.learn.javase.concurrent.TheBeautyOfJavaConcurrency.chapter1;

/**
 * 线程本地变量
 *
 * @author 熊乾坤
 * @date 2020-11-18 10:04
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadA ta = new ThreadA("ThreadA");
        ThreadB tb = new ThreadB("ThreadB");
        ta.start();
        tb.start();
        System.out.println("Main is Over");
    }

    private static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            THREAD_LOCAL.set(Thread.currentThread().getName() + "-ThreadA");
            System.out.println(THREAD_LOCAL.get());
            THREAD_LOCAL.remove();
        }
    }

    private static class ThreadB extends Thread {
        public ThreadB(String name) {
            super(name);
        }

        @Override
        public void run() {
            THREAD_LOCAL.set(Thread.currentThread().getName() + "-ThreadB");
            System.out.println(THREAD_LOCAL.get());
            THREAD_LOCAL.remove();
        }
    }

}
