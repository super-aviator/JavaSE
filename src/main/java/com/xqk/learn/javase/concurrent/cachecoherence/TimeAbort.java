package com.xqk.learn.javase.concurrent.cachecoherence;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 守护进程
 *
 * @author 熊乾坤
 * @date 2020-07-16 16:54
 */
public class TimeAbort {
    private boolean start = true;

    public TimeAbort() {
        this(4, "Abort occur!");
    }

    public TimeAbort(double seconds) {
        this(seconds, "Abort occur!");
    }

    public TimeAbort(double seconds, String msg) {
        CompletableFuture.runAsync(() -> {
            try {
                while (start) {
                    start = false;
                    TimeUnit.SECONDS.sleep((long) seconds);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
            System.exit(0);
        });
    }

    public void restart() {
        this.start = true;
    }
}
