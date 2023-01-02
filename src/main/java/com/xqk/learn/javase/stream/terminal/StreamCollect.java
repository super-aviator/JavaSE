package com.xqk.learn.javase.stream.terminal;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用流的collect方法能够将流中的元素收集到集合中去。
 *
 * @author 熊乾坤
 * @since 2019/9/19 11:20
 */
public class StreamCollect {
    static Stream<String> stream() throws IOException {
        return Files.lines(Paths.get("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt"))
                .flatMap(t -> Arrays.stream(t.split("\\s+")))
                .map(String::trim);
    }

    @Data
    @AllArgsConstructor
    private static class Entry<K, V> {
        private K key;
        private V value;
    }

    private static Stream<Entry<String, String>> entryStream() throws IOException {
        return Files.lines(Paths.get("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt"))
                .flatMap(t -> Arrays.stream(t.split("\\s+")))
                .map(t -> new Entry<>(t, t));
    }

    public static void main(String[] args) throws IOException {

        Set<String> words = stream().collect(Collectors.toCollection(LinkedHashSet::new));
        //.collect(Collectors.toCollection(HashSet::new));
        //.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words);

        //使用toMap将流中的元素收集到Map中
        System.out.println(entryStream().collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
    }
}
