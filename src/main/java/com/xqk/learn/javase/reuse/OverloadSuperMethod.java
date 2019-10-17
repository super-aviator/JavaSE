package com.xqk.learn.javase.reuse;

/**
 * OverloadSuperMethod 重载父类的方法
 * <p>
 * 在子类中重载父类的方法不会屏蔽任何父类中的重载版本
 *
 * @author 熊乾坤
 */
public class OverloadSuperMethod {

    public static void main(String[] args) {
        DeriveClass dc = new DeriveClass();
        dc.method(6.66f);
        dc.method(666);
    }

    private static class SuperClass {
        void method(float f) {
            System.out.println(f);
        }
    }

    private static class DeriveClass extends SuperClass {
        void method(int i) {
            System.out.println(i);
        }
    }
}



