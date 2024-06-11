package com.xqk.learn.javase.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer里面有一个TimerQueue，一个TimerThread，TimerThread线程只有当运行完一个任务时，才会从TimerQueue中获取下一个任务。
 * 如果TimerTask中抛出了任何非InterruptionException，则TimerQueue中的任务会被清除，TimerThread会停止。
 * 下面代码中调用Thread.sleep方法时，TimerThread线程会被阻塞，第二个任务不会被执行。。
 * 在线程池任务的run方法中使用cache捕获异常是最佳实践呢。
 * <p>
 * 输出结果：
 * ------one task------
 * Exception in thread "Timer-0" java.lang.RuntimeException
 * at com.xqk.learn.javase.util.TimerLearn$1.run(TimerLearn.java:22)
 * at java.util.TimerThread.mainLoop(Timer.java:555)
 * at java.util.TimerThread.run(Timer.java:505)
 *
 * @author 熊乾坤
 * @since 2020-12-06 14:34
 */
public class TimerLearn {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------one task------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException();
            }
        }, 500L);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------two task------");

            }
        }, 1000);
    }
}
