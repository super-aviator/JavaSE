package com.xqk.learn.javase.polymorphic;

/**
 * @author 熊乾坤
 * @date 2019-8-22
 */
public class PolymorphicWithConstructor {
    public static void main(String[] args) {
//        new Sub(10);
        new Super();
    }

    private static class Super {
        Super() {
            System.out.println("Before Super Class Constructor");
            //这个方法是多态的，会绑定到派生类的对象上
            doSomething();
            System.out.println("After Super Class Constructor");
        }

        public void doSomething() {
            System.out.println("Super Class doSomething");
        }
    }

    private static class Sub extends Super {
        private int i = 1;

        Sub(int i) {
            this.i = i;
            System.out.println("Sub Class Constructor :" + i);
        }

        @Override
        public void doSomething() {
            System.out.println("Sub Class doSomething :" + i);
        }
    }
}
