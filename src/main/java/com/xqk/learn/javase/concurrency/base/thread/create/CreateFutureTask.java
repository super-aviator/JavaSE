package com.xqk.learn.javase.concurrency.base.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 熊乾坤
 * @since 2021-03-13 12:34
 */
public class CreateFutureTask implements Callable<String> {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CreateFutureTask());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String call() {
        return "hello";
    }
}
