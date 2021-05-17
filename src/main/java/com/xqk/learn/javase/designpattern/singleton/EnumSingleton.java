package com.xqk.learn.javase.designpattern.singleton;

/**
 * 基于枚举的单例模式
 * 缺点是需要继承非Enum的类是不适用
 */
public enum EnumSingleton {
    INSTANCE;

    public void leaveTheBuilding() {

    }
}
