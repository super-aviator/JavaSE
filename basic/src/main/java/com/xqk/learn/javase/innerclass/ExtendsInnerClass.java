package com.xqk.learn.javase.innerclass;

/**
 * ExtendsInnerClass
 * <p>
 * 如果一个类想要继承自内部类，那么需要显式的写一个构造器，参数为外围类的对象引用，并在该构造器中显式的调用该引用的super方法
 *
 * @author 熊乾坤
 */
public class ExtendsInnerClass extends WithInnerClass.InnerClass {
    private ExtendsInnerClass(WithInnerClass wi) {
        //TODO 特别注意，特殊语法
        wi.super();
    }

    public static void main(String[] args) {
        //需要显式的传入外围类的对象，提供需要的引用
        WithInnerClass wi = new WithInnerClass();
        ExtendsInnerClass extendsInnerClass = new ExtendsInnerClass(wi);
        extendsInnerClass.f();
    }
}

class WithInnerClass {
    class InnerClass {
        void f() {
            System.out.println("Inner class f()");
        }
    }
}