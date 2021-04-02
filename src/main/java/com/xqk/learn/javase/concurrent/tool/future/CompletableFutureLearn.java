package com.xqk.learn.javase.concurrent.tool.future;

import com.xqk.learn.javase.concurrent.executor.tasks.NapTask;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 熊乾坤
 * @date 2020-07-12 18:51
 */
public class CompletableFutureLearn {

    public static void main(String[] args) {
        List<CompletableFuture> napTaskList =
                IntStream
                        .range(0, 10)
                        .mapToObj(NapTask::new)
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());

        //napTaskList.forEach(CompletableFuture::join);
        System.out.println("Main thread complete! ");
    }
}
