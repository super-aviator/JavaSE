package com.xqk.learn.javase.stream.intermedial;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 在Stream.filter方法中，如果流中的元素不满足Predicate，那么会直接删除该元素，达到过滤的效果。
 * 但是在Optional.filter方法中，如果流中的元素不满足Predicate,那么只会将其封装为Optional.empty；如果满足，则直接将Optional返回
 * 这是可以接受的，因为流中返回Optional的方法都是单个的元素，该元素只会有存在和不存在两种状态。
 *
 * 当流的skip的参数超过流的大小时，会返回一个
 *
 * @author 熊乾坤
 * @date 2019/9/18 19:44
 */
public class OptionalFilter {
    private static final String[] STR_STEAM = {"hello", "world", "", "name", "is", "xqk"};

    private static Stream<String> testStream() {
        return Arrays.stream(STR_STEAM);
    }

    private static void test(String action, Predicate<String> pred) {
        System.out.println("*******" + action + "********");
        for (int i = 0; i <= STR_STEAM.length; i++) {
            //这里在for循环中，每循环一次，都新创建一个流
            System.out.println(testStream().skip(i)
                    .findFirst()
                    .filter(pred));
        }
    }

    public static void main(String[] args) {
        test("true", t -> true);
        test("false", t -> false);

        Stream.of("xqk").skip(2).forEach(t -> System.out.println("*->"));
    }
}