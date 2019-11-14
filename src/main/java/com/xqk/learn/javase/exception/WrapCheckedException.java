package com.xqk.learn.javase.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * WrapCheckedException
 * 为了避免受检异常所带来的麻烦，可以将受检异常包装进运行时异常之中
 * 然后就不需要为受检异常编写处理代码，同时在需要捕获时，调用getCause()方法得到原始的受检异常的信息
 * <p>
 * 异常处理的终极名言： <code>只有在知道如何处理异常的情况下才捕获异常，否则就向上抛出，避免异常被吞并</code>
 *
 * 异常的继承结构(经常忘记)：
 * --------------------Throwable
 * ----------------------/|
 * -------------Exception Error(虚拟机异常)
 * ----------------/\
 * RuntimeException  extends Exception
 *
 * @author 熊乾坤
 */
public class WrapCheckedException {

    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();

        for (int i = 0; i < 4; i++) {
            try {
                wce.getWrapCheckedException(i);
            } catch (RuntimeException e) {
                //调用getCause方法获取原始的异常
                Throwable t = e.getCause();
                t.printStackTrace();
            }
        }
    }

    private void getWrapCheckedException(int i) {
        try {
            switch (i) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("who am i? i`m nobody");
                case 3:
                    throw new InterruptedException();
                default:
                    throw new ArrayIndexOutOfBoundsException();
            }
        } catch (Exception e) {
            // 使用非受检异常对受检异常进行包装
            throw new RuntimeException(e);
        }
    }
}