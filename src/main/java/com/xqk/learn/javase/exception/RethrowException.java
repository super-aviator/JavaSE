package com.xqk.learn.javase.exception;

import com.xqk.learn.javase.exception.exceptions.OneException;

/**
 * RethrowException 重抛异常:
 * 1.重抛新的异常会丢失旧异常的异常信息。
 * 2.重抛旧异常之前，调用fillStackTrace()，会将栈帧重新填充为当前方法开始调用
 * <p>
 * 使用异常的Throwable构造器（或者使用initCause()），可以将两个异常连接起来。
 *
 * @author 熊乾坤
 */
public class RethrowException {
    public static void main(String[] args) {
        RethrowException re = new RethrowException();
        try {
            re.g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void f() throws OneException {
        System.out.println("throw a OneException form f ");
        throw new OneException();
    }

    private void g() throws Exception {
        try {
            f();
        } catch (OneException e) {
            System.out.println("throw a TowException form g ");
//            使用包装的方式重新抛出新的异常，控制台会捕获两个异常
//            throw new Exception(e);

//            重新抛出新的异常会丢失旧异常的信息
//             throw new TwoException();

//            调用异常的fillInStackTrace方法后，异常的开始栈会从方法g()开始而非f(),但是异常是从f()抛出的
//             throw (Exception)e.fillInStackTrace();

//            简单的重抛异常，异常栈帧从f()开始
//            throw e;
        }
    }
}

