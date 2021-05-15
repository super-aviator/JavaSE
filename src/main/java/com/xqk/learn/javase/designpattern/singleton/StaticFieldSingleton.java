package com.xqk.learn.javase.designpattern.singleton;

/**
 * 使用类的静态成员变量实现的单例模式
 *
 * @author 熊乾坤
 * @since 2021-05-14 18:46
 */
public class StaticFieldSingleton {
    public static final StaticFieldSingleton STATIC_FIELD_SINGLETON = new StaticFieldSingleton();

    private StaticFieldSingleton() {
        // 特权客户端可以使用 AccessibleObject.setAccessible 方法，以反 射方式调用私有构造方法 (条目 65)。如果需要防御此攻击
        // 请修改构造函数，使其在请求创建第二个实例时抛出异常。
        if (STATIC_FIELD_SINGLETON != null) {
            throw new RuntimeException();
        }
    }


}
