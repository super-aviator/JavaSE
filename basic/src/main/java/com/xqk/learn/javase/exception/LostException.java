package com.xqk.learn.javase.exception;

import com.xqk.learn.javase.exception.exceptions.TrivialException;
import com.xqk.learn.javase.exception.exceptions.VeryImportException;

/**
 * LostException 异常丢失的两种情况：
 * 1：在finally块抛出新的异常，try块中抛出的旧的异常信息会丢失
 * 2：在finally块中执行return语句,try块抛出的异常就会丢失（前提是没有catch块）
 *
 * @author 熊乾坤
 */
public class LostException {

    public static void main(String[] args) {
        // [1]
        try {
            LostException le = new LostException();
            try {
                le.f();
            } finally {
                le.g();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------");

        // [2]
        try {
            LostException le = new LostException();
            le.f();
        } finally {
            return;
        }

    }

    private void f() throws VeryImportException {
        throw new VeryImportException();
    }

    private void g() throws TrivialException {
        throw new TrivialException();
    }
}