package com.xqk.learn.javase.exception;

import com.xqk.learn.javase.exception.exceptions.DerivedException;
import com.xqk.learn.javase.exception.exceptions.OneException;
import com.xqk.learn.javase.exception.exceptions.OriginalException;

/**
 * 对于普通方法：
 * 子类能够声明抽象类基类或者接口所声明的异常的子异常
 * <p>
 * 对于构造方法：
 * 上述的异常限制不再适用，但是子类的异常声明至少需要包含父类构造函数所声明的异常
 * <p>
 * 派生类构造器不能捕获基类构造器抛出的异常
 * 不能基于异常说明来重载方法
 *
 * @author 熊乾坤
 * @since 2020-02-04 14:53
 */
public class ExceptionRestrict extends AbstractClass {
    public static void main(String[] args) {
        ExceptionRestrict er = new ExceptionRestrict();
        try {
            er.f();
        } catch (OriginalException e) {
            System.out.println(e.toString());
        }
    }

    @Override
        //void f() throws DerivedException, OneException { //不能抛出其他异常
    void f() throws DerivedException {
        throw new DerivedException();
    }
}

class ConstructClass extends MyClass {

    ConstructClass() throws OriginalException, OneException {
    }
}

abstract class AbstractClass {
    abstract void f() throws OriginalException;
}

class MyClass {
    MyClass() throws OriginalException {
    }
}
