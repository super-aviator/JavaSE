package com.xqk.learn.javase.polymorphic;

import lombok.extern.slf4j.Slf4j;

/**
 * 多态中的非常饶人的知识
 * <p>
 * 1. 域访问不是多态的，在编译时就已经确定
 * 2. 非static和final方法是多态的，在编译时就已经绑定
 * 3. static方法或者private(隐式是final)不是多态的，没有多态的属性
 *
 * @author 熊乾坤
 * @date 2018-8-20
 */
@Slf4j
public class Polymorphic {
    //TODO 知识点总结

    public static void main(String[] args) {
        Super s = new Sub();
        Sub s1 = new Sub();
        log.info(String.valueOf(s.f));
        log.info(String.valueOf(s.getValue()));
        log.info(String.valueOf(s1.getSuperValue()));
    }

    private static class Super {
        public int f = 0;

        public int getValue() {
            return f;
        }
    }

    private static class Sub extends Super {
        public int f = 1;

        @Override
        public int getValue() {
            return f;
        }

        /**
         * 使用super关键字显示的获取基类的f
         *
         * @return 基类的f
         */
        public int getSuperValue() {
            return super.f;
        }
    }
}
