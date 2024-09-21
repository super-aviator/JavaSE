package com.xqk.lean.framework.onjava.enums;

/**
 * @author xiongqiankun
 * @since 2023/1/2 15:07
 */
public enum SpicinessEnum {
    NOT, MILD, MEDIUM, HOT, FLAMING;

    public static void main(String[] args) {
        for (SpicinessEnum e : SpicinessEnum.values()) {
            System.out.println(e);
        }

        for (Enum e : SpicinessEnum.class.getEnumConstants()) {
            System.out.println(e);
        }
    }
}
