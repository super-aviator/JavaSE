package com.xqk.learn.javase.virtualmachine.invokedynamic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Random;

/**
 * MehtodHandle
 *
 * @author xiongqiankun
 * @since 2022/1/20 19:28
 */
public class MethodHandle {
    public void println(String args) {
        System.out.println(args);
    }

    public static void main(String[] args) throws Throwable {
        Object obj = new Random().nextInt() % 2 == 0 ? System.out : new MethodHandle();
        invokeDynamic(obj).invokeExact("abc");
    }

    public static java.lang.invoke.MethodHandle invokeDynamic(Object obj) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup()
                            .findVirtual(obj.getClass(), "println", methodType)
                            .bindTo(obj);
    }
}
