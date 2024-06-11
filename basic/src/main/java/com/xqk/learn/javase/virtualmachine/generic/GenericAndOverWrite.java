package com.xqk.learn.javase.virtualmachine.generic;

/**
 * GenericAndOverWirte
 *
 * @author xiongqiankun
 * @since 2022/1/24 11:14
 */
public class GenericAndOverWrite {
    // public static void method(List<String> list) {
    //
    // }
    //
    // public static void method(List<Integer> list) {
    //
    // }

    // public static String method(List<String> list) {
    //     return "";
    // }
    //
    // public static Integer method(List<Integer> list) {
    //     return 0;
    // }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
