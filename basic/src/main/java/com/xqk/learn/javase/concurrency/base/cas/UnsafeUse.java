package com.xqk.learn.javase.concurrency.base.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author 熊乾坤
 * @since 2021-03-16 23:51
 */
public class UnsafeUse {
    private volatile long status = 0;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(Unsafe.class);
        UnsafeUse unsafeUse = new UnsafeUse();
        long statusOffset = unsafe.objectFieldOffset(UnsafeUse.class.getDeclaredField("status"));
        System.out.println("CAS操作结果：" + unsafe.compareAndSwapLong(unsafeUse, statusOffset, 0, 1));
        System.out.println(unsafeUse.status);

        System.out.println("CAS操作结果：" + unsafe.compareAndSwapLong(unsafeUse, statusOffset, 0, 1));
        System.out.println("修改后的值：" + unsafeUse.status);
    }
}
