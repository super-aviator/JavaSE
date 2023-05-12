package com.xqk.learn.javase.concurrency.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qiankun.xiong
 * @since 2023/4/23 09:17
 */
public class synchronizedList {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("a");
        list.add("b");
        list.removeIf(item-> "b".equals(item));
        System.out.println(list);
    }
}
