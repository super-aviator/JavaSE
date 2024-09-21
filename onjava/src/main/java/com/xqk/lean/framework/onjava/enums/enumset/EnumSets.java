package com.xqk.lean.framework.onjava.enums.enumset;

import com.xqk.lean.framework.onjava.enums.OzWitchEnums;

import java.util.EnumSet;

/**
 * @author qiankun.xiong
 * @since 2023/2/25 11:21
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<OzWitchEnums> enumSet = EnumSet.allOf(OzWitchEnums.class);
        System.out.println(enumSet);
        enumSet.remove(OzWitchEnums.EAST);
        System.out.println(enumSet);
        enumSet=EnumSet.complementOf(enumSet);
        System.out.println(enumSet);
    }
}
