package com.xqk.learn.javase.reflect.proxy;

public class SomeMethodsImpl implements SomeMethods {

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
    }

    @Override
    public void doSomethingElse() {
        System.out.println("SimpleProxy doSomethingElse");
    }
}