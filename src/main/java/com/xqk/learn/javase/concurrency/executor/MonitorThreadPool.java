package com.xqk.learn.javase.concurrency.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * MonitorThreadPool
 * 通过继承ThreadPoolExecutor方法的beforeExecute、afterExecute、terminated方法，可以对线程池进行监控
 *
 * @author xiongqiankun
 * @since 2022/1/4 15:00
 */
// @Slf4j(topic = "线程池")
@Slf4j
public class MonitorThreadPool extends ThreadPoolExecutor {
    public MonitorThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MonitorThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MonitorThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MonitorThreadPool(int corePoolSize,
                             int maximumPoolSize,
                             long keepAliveTime,
                             TimeUnit unit,
                             BlockingQueue<Runnable> workQueue,
                             ThreadFactory threadFactory,
                             RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        log.info("执行了beforeExecute方法-Thread:{},Runnable:{}", t, r);
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        log.info("执行了afterExecute方法-Thread:{},Throwable:{}", r, t);
        super.afterExecute(r, t);
    }

    @Override
    protected void terminated() {
        log.warn("执行了terminated方法-terminated!!!");
        super.terminated();
    }

    public static void main(String[] args) throws InterruptedException {
        var monitorThreadPool = new MonitorThreadPool(1, 2, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));
        for (int i = 0; i < 3; i++) {
            monitorThreadPool.execute(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    log.error("", e);
                }
            });
        }
        monitorThreadPool.shutdown();
        while (!monitorThreadPool.isTerminated()) {
            Thread.sleep(1000);
        }
        log.info("done!");
    }
}
