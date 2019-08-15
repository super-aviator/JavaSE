package com.xqk.learn.javase.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * ClosureSupport 闭包
 * <p>
 * 闭包指的是返回lambda的方法中，lambda引用了外部的变量，这种情况就叫闭包。
 * 如果语言不能自动解决这个问题，那将变得非常具有挑战性。 能够解决这个问题的语言被称为支持闭包滴语言。
 * <p>
 * 为了满足闭包，需要满足以下几个要求
 * 1. lambda中引用的外部的局部变量必须是 final 或者 实际的 final （effectively final）实际的final是指需要保证这个变量在改范围内不能被修改，否则编译时报错。
 * 2. lambda中引用的外部的局部变量的集合或者其他引用类型,需要保证引用指向的对象不变，而对象本身的内容是可以变的。
 * 3. lambda中如果引用的是外部的对象的引用，只要保证引用只想的对象不变，则不需要使用上边的闭包原则，指向的对象可以随意更改，并且调用方法产生的多个lambda共享对象的这个成员变量。
 *
 * @author 熊乾坤
 */
public class ClosureSupport {
    private int closureInt = 10;
    private ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ClosureSupport c = new ClosureSupport();
        IntSupplier is1 = c.getIntSupplier(1);
        System.out.println(is1.getAsInt());

//        由于list是在方法中创建，所以不会共享，调用一次函数就生成一个List,所以is2和is22各自拥有一个list对象
        Supplier<List<Integer>> is2 = c.getCollectionSupplier();
        System.out.println(is2.get());
        Supplier<List<Integer>> is22 = c.getCollectionSupplier();
        System.out.println(is22.get());

        IntSupplier is3 = c.getIntSupplierWithOuterClass();
        System.out.println(is3.getAsInt());

//        所有函数共享外部对象的list
        Supplier<List<Integer>> is4 = c.getCollectionSupplierWithOutClass();
        System.out.println(is4.get());
        Supplier<List<Integer>> is44 = c.getCollectionSupplierWithOutClass();
        is44.get().add(999);
        System.out.println(is4.get());
    }

    /**
     * [1]
     *
     * @param x x
     * @return IntSupplier
     */
    private IntSupplier getIntSupplier(int x) {
        //如果不改变局部变量，则i实际是final的，只是没有显式说明。
        int i = 1;

        // final int i=1;       //error 显式的使用final也是可以的。
        // return ()->x+i++;    //error 这里的i必须为final或者实际上是final的。
        // x++;                 //error 方法传进来的参数同样需要使用闭包原则。
        return () -> x + i;
    }

    /**
     * [2]
     *
     * @return Supplier
     */
    private Supplier<List<Integer>> getCollectionSupplier() {
        //ok 这个可以有
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        return () -> list;
    }

    /**
     * [3]
     *
     * @return IntSupplier
     */
    private IntSupplier getIntSupplierWithOuterClass() {
        closureInt++;
        return () -> closureInt;
    }

    /**
     * [3]
     */
    private Supplier<List<Integer>> getCollectionSupplierWithOutClass() {
        list.add(1);
        return () -> list;
    }
}