package com.xqk.learn.onjava.enums;

import java.util.Random;

/**
 * @author xiongqiankun
 * @since 2023/1/2 17:57
 */
public class Enums {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Enums.random(OzWitchEnums.class));
        }
    }

    public static  <T extends Enum<T>> T random(Class<T> tClass) {
        return tClass.getEnumConstants()[RANDOM.nextInt(tClass.getEnumConstants().length)];
    }
}