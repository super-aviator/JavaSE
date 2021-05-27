package com.xqk.learn.javase.algorithm.basic;

/**
 * sqrt函数实现：
 * 二分查找
 *
 * @author 熊乾坤
 * @since 2021-05-18 19:20
 */
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(9));
    }

    public int sqrt(int num) {
        int hi = num, ans = -1, lo = 0, mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if ((long) mid * mid <= num) {
                ans = hi;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
