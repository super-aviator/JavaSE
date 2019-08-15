package com.xqk.learn.javase.innerclass;

/**
 * InnerClassConstructor
 *
 * 匿名内部类实现接口或者抽象类的细微区别，但是没啥卵用，都达到了构造器的效果
 *
 * @author 熊乾坤
 */
public class AnonymousInnerClassConstructor {
    public static void main(String[] args) {
        AnonymousInnerClassConstructor innerClassConstructor = new AnonymousInnerClassConstructor();
        innerClassConstructor.interfaceImpl(100);
        innerClassConstructor.abstractImpl(10, 0).f();
    }

    interface Inter {
    }

    /**
     * 接口的匿名内部类不能有构造器参数，但是可以通过实例初始化去模拟构造函数
     *
     * @return Inter对象
     */
    private Inter interfaceImpl(int i) {
        return new Inter() {
            {
                System.out.println("initialize constructor: " + i);
            }
        };
    }

    /**
     * 抽象类和类的匿名内部类可以有构造器参数
     * 可以使用实例初始化模拟构造器的构造过程
     *
     * @param x 测试数据
     * @return Base对象
     */
    private Base abstractImpl(int x, int y) {
        return new Base(x, y) {
            {
                System.out.println("initialize constructor: " + x + " " + y);
            }

            @Override
            public void f() {
                System.out.println("Base f() " + x);
            }
        };
    }
}

/**
 * 构造匿名内部类是首先会调用基类的构造器
 */
abstract class Base {
    Base(int i, int j) {
        System.out.println("Base:" + i);
    }

    public abstract void f();
}