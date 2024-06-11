package com.xqk.learn.javase.stream.intermedial;

import java.util.HashMap;
import java.util.Map;

/**
 * Optional.flatMap会把Optional中的数拆开作为参数，结果直接返回，不会将其包装在Optional中。
 *
 * @author 熊乾坤
 * @since 2019/9/18 20:00
 */
public class OptionalFlatMap {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.get(null);
    }
}
