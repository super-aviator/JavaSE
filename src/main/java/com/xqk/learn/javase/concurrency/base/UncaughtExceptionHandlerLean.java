package com.xqk.learn.javase.concurrency.base;

import org.springframework.util.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 线程池中抛出的未捕获异常，需要设置UncaughtExceptionHandler来捕获异常
 * 1.可以通过设置ThreadFactory，来为每一个新创建的线程时，调用setUncaughtExceptionHandler方法为所有线程设置同一个UncaughtExceptionHandler
 * 2.如果所有线程池都需要相同的UncaughtExceptionHandler，则只需要设置Thread的静态成员变量即可
 *
 * @author 熊乾坤
 * @date 2020-07-14 8:52
 */
public class UncaughtExceptionHandlerLean {
    public static void main(String[] args) {
        //Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
        ExecutorService es = Executors.newCachedThreadPool(new MyThreadFactory());
        es.execute(new ThrowExceptionRunner());
        es.execute(new ThrowExceptionRunner());
        es.shutdown();


        String content = "|a";

        if (!StringUtils.isEmpty(content)) {
            String linkBreak = "|";
            //末尾和开头的|去掉，不用换行
            if (content.endsWith(linkBreak) && content.length() >= 2) {
                content = content.substring(0, content.length() - 1);
            }
            if (content.startsWith(linkBreak) && content.length() >= 2) {
                content = content.substring(1);
            }
            //如果中间有多个|连在一起，先替换为一个|
            content = content.replaceAll("\\|{2,100}", "|");
            //替换所有的|为\n
            content = content.replaceAll("\\|", "*");
        }
        System.out.println(content);
    }

    private static class ThrowExceptionRunner implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " throw a new exception");
            throw new RuntimeException("xqk");
        }
    }

    private static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("handler " + t.getUncaughtExceptionHandler() + " caught a exception: " + e.getMessage());
        }
    }

    private static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            Thread.UncaughtExceptionHandler tu = new MyExceptionHandler();
            System.out.println("设置一个UncaughtExceptionHandler：" + tu);
            t.setUncaughtExceptionHandler(tu);
            return t;
        }
    }
}
