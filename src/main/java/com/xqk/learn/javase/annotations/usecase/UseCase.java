package com.xqk.learn.javase.annotations.usecase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    //注解的元素的类型必须使用原始类型
    long id();

    //注解可以指定默认值
    String description() default "no description";
}
