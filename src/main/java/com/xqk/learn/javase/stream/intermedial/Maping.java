package com.xqk.learn.javase.stream.intermedial;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * map操作将一种类型的流转换为另一种类型的流。
 *
 * @author 熊乾坤
 * @date 2019/9/17 9:28
 */
public class Maping {
    private static final String[] ORIGIN = {"12", "23", "50", "", "200", "190"};

    private static Stream<String> getStream() {
        return Arrays.stream(ORIGIN);
    }

    static class Number {
        private int i;

        Number(int i) {
            this.i = i;
        }

        Number(String i) {
            try {
                this.i = Integer.parseInt(i);
            } catch (NumberFormatException e) {
                this.i = 0;
            }
        }

        @Override
        public String toString() {
            return "Number{" +
                    "i=" + i +
                    '}';
        }
    }

    public static void main(String[] args) {
        //使用map将String->String
        getStream()
                .map(t -> t + "%")
                .forEach(System.out::println);

        //使用map将String->Number
        getStream()
                .map(Number::new)
                .forEach(System.out::println);

        //使用map将Stream<String>->IntStream
        getStream()
                .mapToInt(t -> {
                    try {
                        return Integer.parseInt(t);
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .forEach(System.out::println);
    }
}
