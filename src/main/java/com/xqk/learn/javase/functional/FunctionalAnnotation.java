package com.xqk.learn.javase.functional;

import lombok.extern.slf4j.Slf4j;

/**
 * FunctionalInterface
 * <p>
 * 函数式接口@FunctionalInterface：有且仅有一个方法的接口
 *
 * @author 熊乾坤
 */
@Slf4j
public class FunctionalAnnotation {

    public static void main(String[] args) {
        //这个lambda能够使你做一个有礼貌的淫
        FunctionalInterfaceAnnotation f1 = (msg) -> msg;
        log.info(f1.message("你好"));
    }

    @FunctionalInterface
    private interface FunctionalInterfaceAnnotation {
        String message(String msg);
    }

    /**
     * 上面的@FunctionalInterface 可以在只有一个方法的接口中注解，表示此接口是一个函数式接口。
     * 如果接口中的抽象方法多于一个，则编译会报错。
     */
    @SuppressWarnings("unused")
    private interface NotFunctionalInterface {
        String message(String msg);

        String other(String msg);
    }
}