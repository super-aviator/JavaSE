package com.xqk.learn.javase;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 * **开始的地方
 *
 * @author 熊乾坤
 */
public class HelloWorld {
    // public static void main(String[] args) {
    //     System.out.println("Hello World");
    //     //9223372036854775807
    //     System.out.println(Long.MAX_VALUE);
    //     //-9223372036854775808
    //     System.out.println(Long.MIN_VALUE);
    //
    //
    //     Integer i1 = 40;
    //     Integer i2 = 40;
    //     Integer i3 = 0;
    //     Integer i4 = new Integer(40);
    //     Integer i5 = new Integer(40);
    //     Integer i6 = new Integer(0);
    //
    //     System.out.println("i1=i2   " + (i1 == i2));
    //     System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
    //     System.out.println("i1=i4   " + (i1 == i4));
    //     System.out.println("i4=i5   " + (i4 == i5));
    //     System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
    //     System.out.println("40=i5+i6   " + (40 == i5 + i6));
    // }


    public static void main(String[] args) {
        System.out.println(-2 % 2);
        System.out.println(0.345 % 1);
        DateTimeFormatter dtfnt = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00.000");
        System.out.println(dtfnt.format(Instant.now()
                                               .atZone((ZoneId.of("GMT+8")))));
        HelloWorld he = new HelloWorld();
        System.out.println(he.myPow(1.00000, -2147483648));

        int[] i = new ArrayList<Integer>().stream()
                                          .mapToInt(Integer::intValue)
                                          .toArray();

        System.out.println(new Date(28832401000L));
    }

    public double myPow(double x, long n) {
        double res = pow(x, Math.abs(n));
        return n < 0 ? 1.0 / res : res;
    }

    public double pow(double x, long n) {
        double res = 1.0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}