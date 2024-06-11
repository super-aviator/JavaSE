package com.xqk.learn.onjava.enums;

import java.util.EnumMap;

/**
 * @author qiankun.xiong
 * @since 2023/3/5 11:00
 */
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<OzWitchEnums,Runnable> enumMap = new EnumMap<OzWitchEnums,Runnable>(OzWitchEnums.class);
        enumMap.put(OzWitchEnums.EAST, () -> System.out.println("EAST"));
        enumMap.put(OzWitchEnums.NORTH, () -> System.out.println("NORTH"));
        enumMap.put(OzWitchEnums.WEST, () -> System.out.println("WEST"));
        enumMap.put(OzWitchEnums.SOUTH, () -> System.out.println("SOUTH"));
        enumMap.forEach((key, value) -> value.run());
    }
}
