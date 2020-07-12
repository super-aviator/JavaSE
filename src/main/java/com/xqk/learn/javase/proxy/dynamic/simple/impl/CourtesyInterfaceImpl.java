package com.xqk.learn.javase.proxy.dynamic.simple.impl;

import com.xqk.learn.javase.proxy.dynamic.simple.interfaces.CourtesyInterface;
import com.xqk.learn.javase.proxy.dynamic.simple.interfaces.OtherInterface;

/**
 * 具体的实现类，是用户编写的业务代码
 *
 * @author 熊乾坤
 * @date 2020-02-04 20:56
 */
public class CourtesyInterfaceImpl implements OtherInterface, CourtesyInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello！");
    }

    @Override
    public void sayHelloToSomebody(String name) {
        System.out.println("Hello！" + name);
    }

    @Override
    public String getHelloWords() {
        return "Hello Somebody";
    }

    @Override
    public String toString() {
        return "CourtesyInterfaceImpl{" + '}';
    }
}
