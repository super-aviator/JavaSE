package com.xqk.learn.javase.concurrency.executor.demo;

import com.xqk.learn.javase.concurrency.base.threadfactory.IncrementThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池示例
 *
 * @author qiankun.xiong
 * @since 2023/12/12 17:10
 */
@Slf4j
public class ThreadPoolExecutorDemo {
    /** 首页核心线程名称 */
    private static final String HOME_PAGE_THREAD_POOL_NAME = "homepage-thread-pool";
    /** 非首页核心线程名称 */
    private static final String SERVICE_THREAD_POOL_NAME = "service-thread-pool";
    /** 线程池日志打印线程名称 */
    private static final String PRINT_THREAD_POOL_NAME = "print-thread-pool";

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorDemo config = new ThreadPoolExecutorDemo();
        ThreadPoolExecutor t1 = config.getHomepageThreadPoolExecutor();
        ThreadPoolExecutor t2 = config.getServiceThreadPoolExecutor();
        ScheduledThreadPoolExecutor s1 = config.getScheduledThreadPoolExecutor(t1, t2);
        log.info("ThreadPoolExecutor init done!");
        Thread.sleep(1000);
        for (int i = 0; i < t1.getCorePoolSize() * 2; i++) {
            int finalI = i;
            t1.execute(() -> {
                log.info("t1 task {}", finalI);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    /**
     * 首页核心线程池
     *
     * @return ThreadPoolExecutor
     */
    public ThreadPoolExecutor getHomepageThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                40,
                80,
                120,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(40),
                new IncrementThreadFactory(HOME_PAGE_THREAD_POOL_NAME),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        threadPoolExecutor.prestartAllCoreThreads();
        return threadPoolExecutor;
    }

    /**
     * 非核心业务线程池
     *
     * @return ThreadPoolExecutor
     */
    public ThreadPoolExecutor getServiceThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                30,
                60,
                120,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(60),
                new IncrementThreadFactory(SERVICE_THREAD_POOL_NAME),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        threadPoolExecutor.prestartAllCoreThreads();
        return threadPoolExecutor;
    }

    /**
     * 线程池状态定时打印日志Schedule
     *
     * @return ScheduledThreadPoolExecutor
     */
    public ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(ThreadPoolExecutor homepageTheadPool, ThreadPoolExecutor serviceThreadPool) {
        Runnable printRunnable = () -> {
            log.info("HomepageThreadPoolExecutor poolSize={},activeCount={},queueSize={}", homepageTheadPool.getPoolSize(), homepageTheadPool.getActiveCount(),
                    homepageTheadPool.getQueue().size());
            log.info("ServiceThreadPoolExecutor poolSize={},activeCount={},queueSize={}", serviceThreadPool.getPoolSize(), serviceThreadPool.getActiveCount(),
                    serviceThreadPool.getQueue().size());
        };
        ScheduledThreadPoolExecutor printScheduleThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new IncrementThreadFactory(PRINT_THREAD_POOL_NAME));
        printScheduleThreadPoolExecutor.scheduleAtFixedRate(printRunnable, 5L, 10L, TimeUnit.SECONDS);
        return printScheduleThreadPoolExecutor;
    }
}
