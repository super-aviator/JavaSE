package com.xqk.learn.javase.concurrent.executor;

import com.xqk.learn.javase.concurrent.executor.tasks.NapTask;
import com.xqk.learn.javase.util.concurrent.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

/**
 * @author 熊乾坤
 * @since 2019-12-20 14:40
 */
public class SingleThreadExecutorLearn {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        LongStream
                .rangeClosed(1, 10)
                .mapToObj(NapTask::new)
                //.mapToObj(InterferingTask::new)
                .forEach(es::execute);
        es.shutdown();
        while (!es.isTerminated()) {
            System.out.println(Thread.currentThread().getName() + " is wait !");
            new Nap(0.1);
        }
        System.out.println("done !");
    }
}
