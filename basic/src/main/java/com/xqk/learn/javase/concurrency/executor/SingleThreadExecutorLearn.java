package com.xqk.learn.javase.concurrency.executor;

import com.xqk.learn.javase.concurrency.executor.tasks.NapTask;
import com.xqk.learn.javase.util.concurrent.Nap;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

/**
 * @author 熊乾坤
 * @since 2019-12-20 14:40
 */
@Slf4j(topic = "***")
// @Slf4j
public class SingleThreadExecutorLearn {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        LongStream.rangeClosed(1, 10)
                  .mapToObj(NapTask::new)
                  //.mapToObj(InterferingTask::new)
                  .forEach(es::execute);
        es.shutdown();
        while (!es.isTerminated()) {
            log.info(Thread.currentThread()
                           .getName() + " is wait !");
            new Nap(0.1);
        }
        log.info("done !");
    }
}
