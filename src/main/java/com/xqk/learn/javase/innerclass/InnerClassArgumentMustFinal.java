package com.xqk.learn.javase.innerclass;

/**
 * InnerArgumentMustFinal
 */

interface InnerClass {
    public void execute();
}

public class InnerClassArgumentMustFinal {

    public static void main(String[] args) {
        InnerClassArgumentMustFinal argumentMustFinal = new InnerClassArgumentMustFinal();
        argumentMustFinal.genericInnerClass(10).execute();
    }

    /**
     * java对闭包的支持：方法中的匿名内部类，如果想要使用方法中传进来的参数，必须使用final修饰该参数，以保证该参数不会被改变，如果确保在内部类中，
     * 该参数没有被改变，则可以省略final。
     */
    public InnerClass genericInnerClass(int x) {
        return new InnerClass() {
            @Override
            public void execute() {
                // x+=1;不允许改变x的值，
                System.out.println("InnerClass.execute() " + x);
            }
        };
    }
}