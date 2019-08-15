package com.xqk.learn.javase.interfaces;

/**
 * MultipleInheritanceMethodConflict
 * 多继承中的方法冲突
 * <p>
 * 在接口的多继承中，如果多个接口或类的方法签名相同(不包括返回值)，则在实现类中会导致接口中方法的冲突，编译报错。
 * 当打算组合接口时，在不同的接口中使用相同的方法名通常会造成代码可读性的混乱，尽量避免这种情况。
 *
 * @author 熊乾坤
 */

public class MultipleInheritanceMethodConflict {

    public static void main(String[] args) {

    }
}

interface inter1 {
    void f();
}

interface inter2 {
    void f(int i);
}

interface inter3 {
    int f();
}

/**
 * 无冲突
 */
@SuppressWarnings("unused")
class NonConflict1 implements inter1, inter2 {
    @Override
    public void f() {
    }

    @Override
    public void f(int i) {
    }
}

/**
 * 无冲突
 */
@SuppressWarnings("unused")
class NonConflict2 implements inter2, inter3 {
    @Override
    public int f() {
        return 1;
    }

    @Override
    public void f(int i) {
    }
}

/* 有冲突。
class Conflict1 implements inter1,inter3{
    public void f(){}
    public int f(){return 1;}
}
*/