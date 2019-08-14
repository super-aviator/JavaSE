package com.xqk.learn.javase.innerclass;

interface Inter {
}

/**
 * InnerClassContructor
 */
public class AnonymousInnerClassConstructor {
    public static void main(String[] args) {
        AnonymousInnerClassConstructor innerClassContructor = new AnonymousInnerClassConstructor();
        innerClassContructor.interfaceImpl();
        innerClassContructor.AbstractImpl(10, 0).f();
    }

    /**
     * 接口的匿名内部类不能有构造器参数
     *
     * @return Inter对象
     */
    public Inter interfaceImpl() {
        return new Inter() {
        };
    }

    /**
     * 抽象类和类的匿名内部类可以有构造器参数
     * 可以使用实例初始化模拟构造器的构造过程
     *
     * @param x 测试数据
     * @return Base对象
     */
    public Base AbstractImpl(int x, int y) {
        return new Base(x) {
            {
                System.out.println("initialize constructor " + x);
            }

            @Override
            public void f() {
                System.out.println("Base f() " + x);
            }
        };
    }
}

abstract class Base {
    //首先调用基类构造器
    Base(int i) {
        System.out.println("Base:" + i);
    }

    public abstract void f();
}

/**
 * output:
 * Base:10
 * initialize constructor 10
 * Base f() 10
 */