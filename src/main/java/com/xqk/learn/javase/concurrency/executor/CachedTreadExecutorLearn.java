package com.xqk.learn.javase.concurrency.executor;

import com.xqk.learn.javase.concurrency.executor.tasks.InterferingTask;
import com.xqk.learn.javase.util.concurrent.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

/**
 * 调用shutdown方法，当池中的所有线程都运行完毕后，会释放所有的线程,isTerminated方法为true，而不调用shutdown，则不会释放，isTerminated方法为false
 *
 * @author 熊乾坤
 * @since 2019-12-20 14:55
 */
public class CachedTreadExecutorLearn {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        LongStream
                .rangeClosed(0, 10)
                //.mapToObj(NapTask::new)
                .mapToObj(InterferingTask::new)
                .forEach(es::execute);
        es.shutdown();
        while (!es.isTerminated()) {
            System.out.println(Thread.currentThread().getName() + "waiting !");
            new Nap(0.2);
        }
        System.out.println("Done !");
    }
}
