package com.xqk.learn.javase.stream.intermedial;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 如何操作Optional的流？
 *
 * @author 熊乾坤
 * @date 2019/9/19 9:12
 */
public class OptionalStream {
    private static final String[] STREAM = {"my", "name", "is", "xqk"};

    private static class Single {
        private String ele;

        Single(String ele) {
            this.ele = ele;
        }

        @Override
        public String toString() {
            return "Single{" +
                    "ele='" + ele + '\'' +
                    '}';
        }
    }

    private static final Random RAND = new Random(47);

    private static Single generateSingle() {
        int num = RAND.nextInt(4);
        switch (num) {
            case 1:
                return new Single(STREAM[num]);
            case 2:
                return new Single(STREAM[num]);
            default:
                return null;
        }
    }

    private Stream<Optional<Single>> stream() {
        //generateSingle方法产生的Single可能为null值，所以使用Optional将其包装
        return Stream.generate(OptionalStream::generateSingle)
                .map(Optional::ofNullable);
    }

    public static void main(String[] args) {
        OptionalStream os = new OptionalStream();
        os.stream()
                .limit(10)
                .peek(System.out::println)
                //使用filter将不包含值的Optional过滤掉
                .filter(Optional::isPresent)
                //使用map将剩下的包含值的Optional中的值取出来
                .map(Optional::get)
                //对值进行打印
                .forEach(System.out::println);
    }
}