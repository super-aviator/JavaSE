package com.xqk.learn.javase.designpattern.singleton;

/**
 * 静态工程的方式实现单例模式
 *
 * @author 熊乾坤
 * @since 2021-05-14 19:01
 */
public class StaticFactorySingleton {
    private static final StaticFactorySingleton STATIC_FACTORY_SINGLETON = new StaticFactorySingleton();

    private StaticFactorySingleton() {
        // 特权客户端可以使用 AccessibleObject.setAccessible 方法，以反 射方式调用私有构造方法 (条目 65)。如果需要防御此攻击
        // 请修改构造函数，使其在请求创建第二个实例时抛出异常。
        if (STATIC_FACTORY_SINGLETON != null) {
            throw new RuntimeException();
        }
    }

    public static StaticFactorySingleton getInstance() {
        return STATIC_FACTORY_SINGLETON;
    }
}
