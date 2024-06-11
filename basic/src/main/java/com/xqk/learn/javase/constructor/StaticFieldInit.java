package com.xqk.learn.javase.constructor;

/**
 * 静态初始化块和类变量的复制语句在类加载的初始化阶段进行；
 * 编译器收集的顺序是由语句在源文件中出现的顺序决定的，
 * 静态语句块中只能访问到定义在静态语句块之前的变量，
 * 定义在它之后的变量，在前面的静态语句块可以赋值，但是不能访问，
 * 否则编译时会有非法的向前引用异常
 */
public class StaticFieldInit {
    static {
        i = 10;
        // System.out.println(i);
    }

    private final static int i;
}
