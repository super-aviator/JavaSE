package com.xqk.learn.javase.concurrent.TheBeautyOfJavaConcurrency.chapter1;

/**
 * 死锁的四个必要条件
 * 1.资源互斥
 * 2.持有并等待（可破坏）
 * 3.不可剥夺
 * 4.形成闭环（可破坏）
 * <p>
 * 解决死锁的几种解决方案：
 * 1.修改资源的申请顺序
 * 2.破坏上面的条件2或者条件4
 *
 * @author 熊乾坤
 * @date 2020-11-18 8:40
 */
public class DeadLock {
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA ta = new ThreadA();
        ThreadB tb = new ThreadB();
        ta.start();
        tb.start();
        //等待两个线程执行结束
        ta.join();
        tb.join();
        System.out.println("Main is over");
    }

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadA start");
            synchronized (RESOURCE_A) {
                System.out.println("ThreadA get resourceA");
                try {
                    System.out.println("ThreadA start sleep");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (RESOURCE_B) {
                    System.out.println("ThreadA get resourceB");
                }
            }
        }
    }

    private static class ThreadB extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadB start");
            //这里如果先申请A,再申请B就可以避免死锁
            synchronized (RESOURCE_B) {
                System.out.println("ThreadB get resourceA");
                try {
                    System.out.println("ThreadB start sleep");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (RESOURCE_A) {
                    System.out.println("ThreadB get resourceB");
                }
            }
        }
    }
}

