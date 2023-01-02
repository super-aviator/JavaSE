package com.xqk.learn.javase.proxy.dynamic.simple.interfaces;

/**
 * 动态代理接口声明，声明了动态代理实现类所具有的方法
 *
 * @author 熊乾坤
 * @since 2020-02-04 20:54
 */
public interface CourtesyInterface {
    void sayHello();

    void sayHelloToSomebody(String name);

    String getHelloWords();

    @Override
    String toString();
}
