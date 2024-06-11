package com.xqk.learn.javase.stream.intermedial;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的如下操作会返一个Optional：
 * 1. findFirst() 返回一个包含第一个元素的 Optional 对象，如果流为空则返回 Optional.empty
 * 2. findAny() 返回包含任意元素的 Optional 对象，如果流为空则返回 Optional.empty
 * 3. max(Comparator) 和 min(Comparator) 返回一个包含最大值或者最小值的 Optional 对象，如果流为空则返回 Optional.empty
 * 4. reduce() 不再以 identity 形式开头，而是将其返回值包装在 Optional 中。（identity 对象成为其他形式的 reduce() 的默认结果，因此不存在空结果的风险）
 * 5. 对于数字流 IntStream、LongStream 和 DoubleStream，average() 会将结果包装在 Optional 以防止流为空。
 * <p>
 * 可以调用Optional对象的isPresent方法对是否包含有结果进行判断，如果结果为空，则返回Optional.empty对象
 * <p>
 * Optional对象的创建：
 * 1. of(T t)只能传递非空的参数，否则，会抛出空指针异常
 * 2. ofNullable(T t)可以传入空或者非空的参数，当为空时，返回Optional.empty,否则返回非空的Optional
 * 3. empty()生成一个空的Optional对象
 *
 * @author 熊乾坤
 * @since 2019/9/18 17:03
 */
public class Optionals {
    private static void precess(Optional<String> optional) {
        if (optional.isPresent()) {
            System.out.println("result is:" + optional.get());
        } else {
            System.out.println("none result");
        }
    }

    private static void precess(OptionalDouble optional) {
        if (optional.isPresent()) {
            System.out.println("result is:" + optional.getAsDouble());
        } else {
            System.out.println("none result");
        }
    }

    /**
     * ifPresent(Consumer)：当值存在时调用 Consumer，否则什么也不做。
     * orElse(otherObject)：如果值存在则直接返回，否则生成 otherObject。
     * orElseGet(Supplier)：如果值存在直接生成对象，否则使用 Supplier 函数生成一个可替代对象。
     * orElseThrow(Supplier)：如果值存在直接生成对象，否则使用 Supplier 函数生成一个异常。
     */
    private static class OptionalConsumer {
        private static void ifPresent(Optional<String> optional) {
            if (optional.isPresent()) {
                System.out.println("result is:" + optional.get());
            } else {
                System.out.println("none result");
            }
        }

        private static void ifPresent1(Optional<String> optional) {
            optional.ifPresent(System.out::println);
        }

        private static void orElse(Optional<String> optional) {
            System.out.println(optional.orElse("default"));
        }

        private static void orElseGet(Optional<String> optional) {
            String temp = "temp";
            System.out.println(optional.orElseGet(() -> temp + " default"));
        }

        private static void orElseThrow(Optional<String> optional) {
            try {
                System.out.println(optional.orElseThrow(NoSuchElementException::new));
            } catch (Exception e) {
                System.out.println("caught exception");
            }
        }
    }

    public static void test(String args, Consumer<Optional<String>> consumer) {
        System.out.println("********" + args + "********");
        consumer.accept(Stream.of(args).findFirst());
        consumer.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        precess(Stream.<String>empty().findFirst());
        precess(Stream.of("hello", "world").findFirst());
        precess(Stream.of("world1", "world2", "world33", "world4").parallel().findAny());
        precess(Stream.of("world1", "world2", "world33", "world4").max(String.CASE_INSENSITIVE_ORDER));
        precess(Stream.of("world1", "world2", "world33", "world4").reduce((a, b) -> a + b));
        precess(IntStream.range(10, 20).average());
        precess(IntStream.empty().average());


        //使用Optional中提供的便捷的方法
        test("ifPresent", OptionalConsumer::ifPresent);
        test("ifPresent1", OptionalConsumer::ifPresent1);
        test("orElse", OptionalConsumer::orElse);
        test("orElseGet", OptionalConsumer::orElseGet);
        test("orElseThrow", OptionalConsumer::orElseThrow);

        //创建Optional
        System.out.println("****************");
        System.out.println(Optional.empty());
        System.out.println(Optional.of("String"));
        try {
            //当of的参数为空时，会抛出异常
            System.out.println(Optional.of(null));
        } catch (NullPointerException e) {
            System.out.println("catch NullPointerException");
        }
        System.out.println(Optional.ofNullable(null));
        System.out.println(Optional.ofNullable("hello"));
    }
}