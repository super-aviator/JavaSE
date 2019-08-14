package com.xqk.learn.javase.effectivejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * 使用ForEach要优于显式的for循环，
 */

public class ForEach58 {

    public static void main(String[] args) {

        // ----------------------错误示例2-------------------------

        Collection<Face> faces1 = Arrays.asList(Face.values());
        Collection<Face> faces2 = Arrays.asList(Face.values());

        for (Iterator<Face> i = faces1.iterator(); i.hasNext(); ) {
            for (Iterator<Face> j = faces2.iterator(); j.hasNext(); )
                System.out.print(i.next() + " " + j.next() + "  ");//会抛出NoSuchElementException异常
        }
        System.out.println();

        // ----------------------错误示例1-------------------------

        Collection<Face> faces = EnumSet.allOf(Face.class);

        for (Iterator<Face> i = faces.iterator(); i.hasNext(); )
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); )
                System.out.print(i.next() + " " + j.next());//但它只打印 6 个重复的组合（从“ONE ONE”到“SIX SIX”），而不是预期的 36 个组合。
        System.out.println();

        // -----------------------正确示范--------------------------

        Collection<Face> faces3 = Arrays.asList(Face.values());
        Collection<Face> faces4 = Arrays.asList(Face.values());

        for (Iterator<Face> i = faces3.iterator(); i.hasNext(); ) {
            Face temp = i.next();
            for (Iterator<Face> j = faces4.iterator(); j.hasNext(); )
                System.out.print(temp + " " + j.next() + "  ");
        }
        System.out.println();
    }

    static enum Face {
        ONE, TWO, THREE, FOUR, FIVE, SIX
    }
}