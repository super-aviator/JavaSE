package com.xqk.learn.javase.reuse;

/**
 * CallSuperConstructor
 * <p>
 * 1. 在导出类构造器中，如果不显式调用基类构造器，那么在导出类构造器中编译器会
 * 自动插入调用基类<code>无参构造器</code>的代码，此时如果基类因为只重写了带参构造器而使
 * 得没有了无参构造器，编译器就会报错。
 * <p>
 * 2. 如果基类没有无参构造函数或者需要显式的调用基类的构造函数，则需要使用super关键字去显式的调用基类的有参构造器
 * <p>
 * 3. 导出类调用基类构造器的super()代码必须放在构造器的第一行，防止产生不安全行为。
 *
 * @author 熊乾坤
 */
public class CallSuperConstructor {

    public static void main(String[] args) {
        DeriveClass dc = new DeriveClass(666);
        System.out.println();
        dc = new DeriveClass();
    }

    private static class SuperClass {

        SuperClass() {
            System.out.println("SuperClass Constructor");
        }

        SuperClass(int i) {
            System.out.println("SuperClass Constructor with args");
        }
    }

    private static class DeriveClass extends SuperClass {

        DeriveClass() {
            System.out.println("DeriveClass Constructor");
        }

        DeriveClass(int i) {
            super(1);
            System.out.println("DeriveClass Constructor with args");
//         super(i);
        }
    }

}