package com.xqk.learn.javase.functional;

import java.util.function.Function;


/**
 * Lambda表达式允许在外部修改变量的值，但是不允许在内部修改外部的变量值
 */
public class ImmutableLambdaVariable {
    public static void main(String[] args) {
        int a = 10;
        Function<Integer, Integer> function1 = x -> x;
        a = 12;

//        Function<Integer,Integer> function2=x-> a++;
    }
}
