package com.xqk.learn.javase.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Java动态代理实现
 */
public class DynamicProxy implements InvocationHandler {
    //需要组合一个被代理对象
    private final Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:" + proxy.getClass() + " method:" + method + " args:" + Arrays.toString(args));
        return method.invoke(obj, args);
    }

    public static void main(String[] args) {
        SomeMethods someMethods = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new Class[]{SomeMethods.class}, new DynamicProxy(new SomeMethodsImpl()));
        someMethods.doSomething();
        someMethods.doSomethingElse();
    }
}