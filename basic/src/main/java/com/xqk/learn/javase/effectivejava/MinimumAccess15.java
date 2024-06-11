package com.xqk.learn.javase.effectivejava;

interface testInterface {
    void test();
}

/**
 * 使类和成员的可访问性最小，对于final修饰的指向可变对象的引用，也需要将其设置为private
 * 对于final修饰的数组引用，可以考虑使用Collections.unmodifiableList方法将其设置为不可更改类型。或者新增一个返回值为原数组拷贝的方法
 * <p>
 * MinimumAccess15
 *
 * @author 熊乾坤
 */
public class MinimumAccess15 {

    public static void main(String[] args) {
        TestClass t = new TestClass();
    }

    private static class TestClass implements testInterface {
        /**
         * 继承接口中的方法必须为声明为public,否则编译报错
         */
        @Override
        public void test() {

        }
    }
}