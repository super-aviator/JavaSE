package com.xqk.learn.javase.concurrency.base.threadfactory;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自增线程工厂
 *
 * @author qiankun.xiong
 * @since 2023/12/12 17:50
 */
@Slf4j
public class IncrementThreadFactory implements ThreadFactory {
    private final AtomicLong threadCounter = new AtomicLong();
    private final String threadPoolName;

    public IncrementThreadFactory(String threadPoolName) {
        this.threadPoolName = threadPoolName;
    }

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadPoolName + "-" + threadCounter.incrementAndGet());
        log.info("IncrementThreadFactory newThread {}", thread.getName());
        return thread;
    }
}
