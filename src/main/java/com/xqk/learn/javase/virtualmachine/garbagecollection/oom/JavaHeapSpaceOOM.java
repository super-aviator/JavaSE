package com.xqk.learn.javase.virtualmachine.garbagecollection.oom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * -Xms20M -Xmx20M
 *
 * @author xiongqiankun
 * @since 2021/8/21 20:17
 */
public class JavaHeapSpaceOOM {
    private final byte[] bytes=new byte[1024*1024*10];

    public static void main(String[] args) {
        final List<Object> list = new ArrayList<>();
        new Thread(()->{
            while (true) {
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " *");
                list.add(new JavaHeapSpaceOOM());
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " *");
            }
        }).start();
    }
}
