package com.xqk.learn.javase.constructor;

/**
 * 可变参数列表
 * <p>
 * [1] 可变参数列表实际上使用的是数据的方式,当参数不是数组时，编译器会隐式的将其转换为数组， 如果参数是数组时，就不会发生转换
 * <p>
 * [2] 对最后一个参数是可变参数列表时，在调用该方法时最后一个参数是可选的，这样会显得api非常滴智能 ᶘᵒᴥᵒᶅ ,注意，编译器强制要求
 * 可变参数列表在方法参数列表顺序的最后。
 * <p>
 * [3] 如程序所示，可变参数列表将参数封装成了数组的形式（getClass中返回以[开头），而且没有依赖自动装箱机制（返回的I表示是基本类型,java.lang.Integer表示装箱类型）
 * <p>
 * VariableArgumentList
 */
public class VariableArgumentList {
    public static void printArr(Object... obj) {
        for (Object i : obj) {
            System.out.println(i);
        }
    }

    //[1]
    public static void printArrRequire(int required, Object... obj) {
        System.out.println("required:" + required);
        for (Object i : obj) {
            System.out.println(i);
        }
    }

    // [2]
    /*
     * public static void test(int... ints,String str){
     *
     * }
     */

    //[3]
    public static void getVALClass(int... ints) {
        System.out.print(ints.getClass() + " ");
        System.out.println(ints.length);
    }

    public static void main(String[] args) {
        printArr("熊乾坤", 12, 12.56, (float) 2345.34);
        // 这里需要强转（否则编译会有警告），因为Integr是Object子类，但是Integer[]不是Object[]子类
        printArr((Object[]) new Integer[]{1, 2, 3, 4, 5});

        printArrRequire(1, "你好", "xqk");
        printArrRequire(1);

        getVALClass(new Integer(1), new Integer(2));
        getVALClass();

        // System.out.println(new Integer(1).getClass());
    }
}