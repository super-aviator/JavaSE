package com.xqk.learn.javase.concurrency.tool.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.xqk.learn.javase.concurrency.executor.tasks.NapTask;

/**
 * @author 熊乾坤
 * @since 2020-07-12 18:51
 */
public class CompletableFutureLearn {

    public static void main(String[] args) {
        List<CompletableFuture> napTaskList =
                IntStream.range(0, 10)
                         .mapToObj(NapTask::new)
                         .map(CompletableFuture::runAsync)
                         .collect(Collectors.toList());

        napTaskList.forEach(CompletableFuture::join);
        System.out.println("Main thread complete! ");
    }

    private void runAsync() {

        CompletableFuture<Boolean> completableFuture = CompletableFuture.supplyAsync(() -> {
                                                                            try {
                                                                                Thread.sleep(1000);
                                                                            } catch (InterruptedException e) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            System.out.println("task result=true");
                                                                            return true;
                                                                        })
                                                                        .thenApplyAsync((result) -> {
                                                                            System.out.println("task1 result=" + result);
                                                                            if (!result) {
                                                                                return false;
                                                                            }
                                                                            try {
                                                                                Thread.sleep(1000);
                                                                            } catch (InterruptedException e) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            return true;
                                                                        })
                                                                        .thenApplyAsync((result) -> {
                                                                            System.out.println("task2 result=" + result);
                                                                            if (!result) {
                                                                                return false;
                                                                            }
                                                                            try {
                                                                                Thread.sleep(1000);
                                                                            } catch (InterruptedException e) {
                                                                                throw new RuntimeException(e);
                                                                            }
                                                                            return true;
                                                                        });
        try {
            System.out.println(completableFuture.get(2, TimeUnit.SECONDS));
        } catch (Exception ignore) {
        }
    }
}
