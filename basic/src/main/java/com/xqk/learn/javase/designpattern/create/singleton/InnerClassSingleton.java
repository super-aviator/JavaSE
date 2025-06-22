package com.xqk.learn.javase.designpattern.create.singleton;

/**
 * 内部类单例模式
 *
 * @author 熊乾坤
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    public void doSomething() {
        // 执行某些操作
    }

    public static class SingletonHolder {
        private static final InnerClassSingleton STATIC_FIELD_SINGLETON = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingleton.SingletonHolder.STATIC_FIELD_SINGLETON;
    }
}