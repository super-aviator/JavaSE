package com.xqk.learn.javase.virtualmachine.garbagecollection.oom;

/**
 * -Xss160k
 *
 * @author xiongqiankun
 * @since 2021/8/22 8:34
 */
public class StackOverflow {
    private int depth = 0;

    public void method() {
        depth++;
        System.out.println("当前栈深度：" + depth);
        long val1 = 1L, val2 = 1L, val3 = 1L, val4 = 1L, val5 = 1L;
        long val6 = 1L, val7 = 1L, val8 = 1L, val9 = 1L, val10 = 1L;
        long val11 = 1L, val12 = 1L, val13 = 1L, val14 = 1L, val15 = 1L;
        method();
    }

    public static void main(String[] args) {
        StackOverflow stackOverflow = new StackOverflow();
        stackOverflow.method();
    }
}
