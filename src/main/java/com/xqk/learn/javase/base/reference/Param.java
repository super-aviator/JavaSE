package com.xqk.learn.javase.base.reference;

import java.lang.reflect.Constructor;

/**
 * java中只有值拷贝，当进入方法时，会拷贝一份a1的引用到栈中，然后将null赋值给此引用，原始的引用依旧指向的是堆中的成员变量
 */
public class Param {
    public Param(Object a1) {
        this.a1 = a1;
    }

    private final Object a1;

    public void change(Object a1) {
        a1 = null;
    }

    public static void main(String[] args) {
        Param param = new Param("*");
        System.out.println(param.a1);
        param.change(param.a1);
        System.out.println(param.a1);
    }
}
