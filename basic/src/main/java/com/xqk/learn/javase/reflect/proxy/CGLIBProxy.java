package com.xqk.learn.javase.reflect.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.Arrays;

public class CGLIBProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //通过设置SuperClass来指定被代理对象
        enhancer.setSuperclass(SomeMethodsImpl.class);
        //设置自定义的方法拦截器
        enhancer.setCallback((MethodInterceptor) (o, method, args1, methodProxy) -> {
            System.out.println("o:" + o.getClass() + " method:" + method + " args:" + Arrays.toString(args1) + " methodProxy:" + methodProxy);
            //通过methodProxy的invokeSuper方法来调用被代理的方法
            return methodProxy.invokeSuper(o, args1);
            //也不能使用代理的方法上调用原始方法，否则会产生循环调用
            //return methodProxy.invoke(o, args1);
            //不能在原始对象上调用原始方法，否则会产生循环调用
            //return method.invoke(o, args1);
        });

        SomeMethodsImpl someMethods = (SomeMethodsImpl) enhancer.create();
        someMethods.doSomething();
        someMethods.doSomethingElse();
    }
}
