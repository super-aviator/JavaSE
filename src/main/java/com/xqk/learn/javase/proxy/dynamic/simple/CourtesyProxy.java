package com.xqk.learn.javase.proxy.dynamic.simple;

import com.xqk.learn.javase.proxy.dynamic.simple.impl.CourtesyInterfaceImpl;
import com.xqk.learn.javase.proxy.dynamic.simple.interfaces.CourtesyInterface;

import java.lang.reflect.Proxy;

/**
 * 代理接口实现类从代理接口中实现的所有方法（包括从Object中获取的方法）都会被代理
 *
 * @author 熊乾坤
 * @since 2020-02-04 21:02
 */
public class CourtesyProxy {
    public static void main(String[] args) {
        CourtesyInterfaceImpl cii = new CourtesyInterfaceImpl();
        CourtesyInvocationHandler cih = new CourtesyInvocationHandler(cii);
        CourtesyInterface ci = (CourtesyInterface) Proxy.newProxyInstance(CourtesyInterfaceImpl.class.getClassLoader(), CourtesyInterfaceImpl.class.getInterfaces(), cih);
        ci.sayHello();
        System.out.println("*******");
        ci.sayHelloToSomebody("熊乾坤");
        System.out.println("*******");
        System.out.println(ci.getHelloWords());
        System.out.println("*******");
        System.out.println(ci.toString());
    }
}