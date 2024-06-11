package com.xqk.learn.javase.effectivejava;

import java.util.regex.Pattern;

/**
 * EffectiveString
 * <p>
 * String中的matches方法会间接地创建Pattern对象，没调用一次就创建一个，这很不EffectiveJava。
 * 如果在此方法中需要多次调用matches方法，则可以缓存一个Pattern成员变量来重复使用，为了性能。
 */
public class EffectiveString06 {
    private Pattern pattern = Pattern.compile("\\w+");

    public static void main(String[] args) {

    }

    public boolean matchAllWords(String[] str) {
        for (String s : str)
            // if (!s.matches("\\w+")) // no 如果多次调用matches方法的话，会创建很多个不必要的中间对象，这样使不得。
            if (!pattern.matcher(s).matches()) // 使用缓存的Pattern对象
                return false;
        return true;
    }
}