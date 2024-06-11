package com.xqk.learn.javase.reuse;

/**
 * 类中所有的 private 方法都隐式地指定为 final。因为不能访问 private 方法，所以不能覆写它。
 * 可以给 private 方法添加 final 修饰，但是并不能给方法带来额外的含义。
 * <p>
 * 值得注意的是，导出类不能覆盖基类的private方法（即private final），因为private final 修饰的方法并不是基类接口的一部分，仅仅是内部方法
 *
 * @author 熊乾坤
 * @since 2019-8-20
 */
@SuppressWarnings("unused")
public class OverridePrivateMethod {
    public static void main(String[] args) {
        DeriveClass dc = new DeriveClass();
        dc.f();
    }

    private static class SuperClass {
        private void f() {
            System.out.println("super class f()");
        }
    }

    private static class DeriveClass {
        //        @Override
        private void f() {
            System.out.println("derive class f()");
        }
    }
}
