package com.xqk.learn.javase.innerclass;

/**
 * ExtendsInnserClass
 * <p>
 * 继承内部类的方法
 */
public class ExtendsInnerClass extends WithInnerClass.InnerClass {
    public ExtendsInnerClass(WithInnerClass wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInnerClass wi = new WithInnerClass();
        ExtendsInnerClass extendsInnerClass = new ExtendsInnerClass(wi);
        extendsInnerClass.f();
    }
}

class WithInnerClass {
    class InnerClass {
        public void f() {
            System.out.println("Inner class f()");
        }
    }
}