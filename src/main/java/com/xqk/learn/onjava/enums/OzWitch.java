package com.xqk.learn.onjava.enums;

/**
 * @author xiongqiankun
 * @since 2023/1/2 15:16
 */
public enum OzWitch {
    WEST("W"), NORTH("N"), EAST("E"), SOUTH("S");

    private final String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        System.out.println(WEST.getDescription());
        System.out.println(NORTH.getDescription());
        System.out.println(EAST.getDescription());
        System.out.println(SOUTH.getDescription());
    }
}
