package com.xqk.learn.javase.concurrency.base.thread.create;

/**
 * @author 熊乾坤
 * @since 2021-03-13 12:34
 */
public class ExtendsThread extends Thread {
    public static void main(String[] args) {
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();
    }

    @Override
    public void run() {
        System.out.println(this.getName());
    }
}
