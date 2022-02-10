package com.xqk.learn.javase.virtualmachine.garbagecollection.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * -XX:MaxDirectMemorySize=10m
 *
 * @author xiongqiankun
 * @since 2021/8/22 15:32
 */
public class DirectMemoryOOM {
    public static void main(String[] args) throws IllegalAccessException {
        int size = 1024 * 1024;
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        while (true) {
            unsafe.allocateMemory(size);
        }
    }
}