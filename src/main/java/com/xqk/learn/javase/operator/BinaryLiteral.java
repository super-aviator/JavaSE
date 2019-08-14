package com.xqk.learn.javase.operator;

/**
 * BinaryLiteral
 * <p>
 * 字面常量：
 * long:L/l
 * float：F/f
 * <p>
 * 前导：
 * 八进制：0
 * 十六进制：0x:0X
 * 二进制：0b:0B 不能定义小数
 * <p>
 * Java7中新增了二进制字面常量(Literal):0b/0B,可以直接赋值到对应的数值类型中,需要注意取值范围。
 *
 * @author 熊乾坤
 */
public class BinaryLiteral {

    public static void main(String[] args) {
        byte i = 0b1111111;
        float j = 0b11111111;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

        System.out.println(j);
    }
}