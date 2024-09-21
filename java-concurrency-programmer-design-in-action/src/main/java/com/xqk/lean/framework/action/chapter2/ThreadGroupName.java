package com.xqk.lean.framework.action.chapter2;

/**
 * @author 熊乾坤
 * @since 2021-02-22 20:23
 */
public class ThreadGroupName implements Runnable {
    public static void main(String[] args) {
        ThreadGroup myTGP = new ThreadGroup("ThreadGroupXQKParent");
        ThreadGroup myTG = new ThreadGroup(myTGP, "ThreadGroupXQK");
        Thread thread1 = new Thread(myTG, new ThreadGroupName(), "T1");
        Thread thread2 = new Thread(myTG, new ThreadGroupName(), "T2");
        Thread thread3 = new Thread(myTGP, new ThreadGroupName(), "T3");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(myTG.activeCount());
        myTG.list();
        myTGP.list();
    }

    @Override
    public void run() {

    }
}
