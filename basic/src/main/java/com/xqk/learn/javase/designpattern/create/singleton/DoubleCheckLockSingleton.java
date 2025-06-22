package com.xqk.learn.javase.designpattern.create.singleton;

/**
 * The type Singleton. 单例设计模式
 * <p>
 * 单利设计模式的主要目的是确保类的实例在内存中是唯一的，一个类有且仅有一个对象
 * 双重检查加锁模式（DCL）
 *
 * @author 熊乾坤
 */
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton STATIC_FIELD_SINGLETON;

    private DoubleCheckLockSingleton() {
        // 特权客户端可以使用 AccessibleObject.setAccessible 方法，以反 射方式调用私有构造方法 (条目 65)。如果需要防御此攻击
        // 请修改构造函数，使其在请求创建第二个实例时抛出异常。
        if (STATIC_FIELD_SINGLETON != null) {
            throw new RuntimeException("Use getInstance() method to get the instance");
        }
    }

    public void doSomething() {
        // 执行某些操作
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (STATIC_FIELD_SINGLETON == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (STATIC_FIELD_SINGLETON == null) {
                    STATIC_FIELD_SINGLETON = new DoubleCheckLockSingleton();
                }
            }
        }
        return STATIC_FIELD_SINGLETON;
    }
}