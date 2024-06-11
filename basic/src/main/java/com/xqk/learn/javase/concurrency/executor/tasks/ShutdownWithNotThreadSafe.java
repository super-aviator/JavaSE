package com.xqk.learn.javase.concurrency.executor.tasks;

import com.xqk.learn.javase.util.concurrent.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author 熊乾坤
 * @since 2019-12-20 15:32
 */
public class ShutdownWithNotThreadSafe implements Runnable {
    private long id;
    //private AtomicBoolean runFlag1;
    private boolean runFlag2;

    public ShutdownWithNotThreadSafe(long id) {
        this.id = id;
        //this.runFlag1 = new AtomicBoolean(true);
        runFlag2 = true;
    }

    public void shutdonw1() {
        //runFlag1.set(false);
    }

    public void shutdonw2() {
        runFlag2 = false;
    }

    @Override
    public void run() {
        //runFlag1.get()&&
        while (runFlag2) {

        }
        System.out.println(id);
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<ShutdownWithNotThreadSafe> result = LongStream
                .rangeClosed(0, 150)
                .mapToObj(ShutdownWithNotThreadSafe::new)
                .peek(es::execute)
                .collect(Collectors.toList());
        es.shutdown();
        new Nap(1);
        result
                .stream()
                .forEach(ShutdownWithNotThreadSafe::shutdonw2);
        new Nap(1);
        System.out.println(es.isTerminated());
    }
}

