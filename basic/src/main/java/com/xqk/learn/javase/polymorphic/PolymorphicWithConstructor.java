package com.xqk.learn.javase.polymorphic;

/**
 * 因此，编写构造器有一条良好规范：做尽量少的事让对象进入良好状态。如果有可能的话，尽量不要调用类中的任何方法。
 * 在构造器中唯一能安全调用的只有基类的 final 方法（包括 private 方法，它们自动属于 final）。这些方法不能被覆写，
 * 因此不会产生意想不到的结果。你可能无法永远遵循这条规范，但应该朝着它努力。
 *
 * @author 熊乾坤
 * @since 2019-8-22
 */
public class PolymorphicWithConstructor {
    public static void main(String[] args) {
        new Sub(10);
        //new Super();
    }

    private static class Super {
        Super() {
            System.out.println("Before Super Class Constructor");
            //这个方法是多态的，会调用在导出类中的复写版本
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
