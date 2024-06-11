package com.xqk.learn.javase.functional;

import java.util.function.Function;

/**
 * 高阶函数指的是参数为一个函数或者返回值为一个函数的函数
 *
 * @author 熊乾坤
 * @since 2019/9/19 18:15
 */
public class HighterLevelFunction {
    private static class One {
    }

    private static class Two {
    }

    //该函数就是一个高阶函数
    private static Two generateTwo(Function<One, Two> func) {
        return func.apply(new One());
    }

    //该函数也是一个高阶函数
    private static Function<One, Two> generateFunction() {
        return t -> new Two();
    }

    private static Function<One, Two> transform(Function<One, Two> function) {
        return function.andThen(two -> {
            System.out.println(two.getClass().getName());
            return two;
        });
    }

    public static void main(String[] args) {
        Two two = generateTwo((t) -> new Two());
        Function function = generateFunction();

        Function<One, Two> func = transform(o -> {
            System.out.println(o.getClass().getName());
            return new Two();
        });

        func.apply(new One());
    }
}
