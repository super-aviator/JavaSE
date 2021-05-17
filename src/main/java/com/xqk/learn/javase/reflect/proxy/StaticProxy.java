package com.xqk.learn.javase.reflect.proxy;

public class StaticProxy implements SomeMethods {

    private final SomeMethods someMethods;

    public StaticProxy(SomeMethods someMethods) {
        this.someMethods = someMethods;
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething() 前置处理");
        someMethods.doSomething();
        System.out.println("doSomething() 后置处理");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("doSomethingElse() 前置处理");
        someMethods.doSomethingElse();
        System.out.println("doSomethingElse() 后置处理");
    }

    public static void main(String[] args) {
        StaticProxy staticProxy=new StaticProxy(new SomeMethodsImpl());
        staticProxy.doSomething();
        staticProxy.doSomethingElse();
    }
}
