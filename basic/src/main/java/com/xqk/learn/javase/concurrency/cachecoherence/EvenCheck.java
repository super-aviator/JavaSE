package com.xqk.learn.javase.concurrency.cachecoherence;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 熊乾坤
 * @since 2020-07-16 16:45
 */
public class EvenCheck implements Runnable {
    private int id;
    private IntGenerator intGenerator;

    EvenCheck(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    public static void check(IntGenerator intGenerator, int threadNum) {
        List<CompletableFuture<Void>> cf = IntStream.range(0, threadNum)
                .mapToObj(id -> new EvenCheck(intGenerator, id))
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
        //别忘了这个惹
        cf.forEach(CompletableFuture::join);
    }

    public static void check(IntGenerator intGenerator) {
        check(intGenerator, 10);
    }

    @Override
    public void run() {
        while (!intGenerator.canceled()) {
            int num = intGenerator.next();
            if (num % 2 != 0) {
                System.err.println(num + " is not even!!");
                intGenerator.cancel();
            }
        }
    }
}
