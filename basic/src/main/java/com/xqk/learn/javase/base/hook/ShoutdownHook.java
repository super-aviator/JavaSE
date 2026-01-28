package com.xqk.learn.javase.base.hook;

/**
 * addShutdownHook方法向JVM注册一个钩子，当JVM关闭时，钩子会被执行
 *
 * @author qiankun.xiong
 * @version 1.0.0
 * @since 2025/8/24 09:46
 */
public class ShoutdownHook {
    public static void main(String[] args) {
        System.out.println("Application is running");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM Shutdown Hook invoked!")));
        System.out.println("Application is shutdown");
    }
}
