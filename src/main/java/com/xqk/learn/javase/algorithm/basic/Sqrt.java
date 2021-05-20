package com.xqk.learn.javase.algorithm.basic;

/**
 * @author 熊乾坤
 * @since 2021-05-18 19:20
 */
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(8));
    }

    public int sqrt(int x) {
        int n = x / 2, r = -1, t = 0;
        while (t <= x) {
            if (t < x) {
                r = n;
                n = n + (n / 2);
            } else {
                n = n / 2;
            }
            t = n * n;
        }
        return r;
    }
}
