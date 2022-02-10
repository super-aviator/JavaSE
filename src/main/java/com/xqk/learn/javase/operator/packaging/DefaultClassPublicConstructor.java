package com.xqk.learn.javase.operator.packaging;

/**
 * 当一个类拥有包访问权限，但是他的构造器是public修饰的，这种情况是一种编程错误，应该避免，
 * 因为在该包的外部是访问不到该类的构造器的，即使该类的构造器是public修饰的嘤嘤嘤
 *
 * @author 熊乾坤
 */
class DefaultClassPublicConstructor {
    public DefaultClassPublicConstructor() {
    }
}
