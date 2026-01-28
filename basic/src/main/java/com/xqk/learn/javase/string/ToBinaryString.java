package com.xqk.learn.javase.string;

/**
 * ToBinaryString
 *
 * @author qiankun.xiong
 * @version 1.0.0
 * @since 2026/1/19 17:18
 */
public class ToBinaryString {
    public static void main(String[] args) {
        int i=10;
        System.out.println(Integer.toBinaryString(i));
        i=i>>1;
        System.out.println(Integer.toBinaryString(i));
        i=i<<1;
        System.out.println(Integer.toBinaryString(i));
    }
}
