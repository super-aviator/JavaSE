package com.xqk.learn.javase.effectivejava;

import java.util.Arrays;

/**
 * ObsoleteReference 过期引用
 * <p>
 * 在第43行中，将自己管理的内存elements的过期数据设置为null,避免了内存泄露。 在java的集合框架中也是这样做的，非常的nice.
 *
 * @author 熊乾坤
 */
public class ObsoleteReference07 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}

@SuppressWarnings("unused")
class Stack {
    private static final int DEFAULT_ELEMENT_LENGTH = 16;
    private Object[] elements;
    private int size;

    public Stack(int length) {
        elements = new Object[length];
    }

    Stack() {
        elements = new Object[DEFAULT_ELEMENT_LENGTH];
    }

    void push(Object obj) {
        ensureCapacity();
        elements[size++] = obj;
    }

    public Object pop() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        Object result = elements[--size];
        // ----------------------------消除过期引用
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = (Arrays.copyOf(elements, size + size / 2));
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements) + "   size:" + size + "   capacity:" + elements.length;
    }
}