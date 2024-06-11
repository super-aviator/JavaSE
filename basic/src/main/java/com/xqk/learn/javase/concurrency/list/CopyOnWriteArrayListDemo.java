package com.xqk.learn.javase.concurrency.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 熊乾坤
 * @since 2021-04-08 15:12
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayListDemo cowald = new CopyOnWriteArrayListDemo();
        cowald.weekConsistencyIterator();
    }

    /**
     * 测试弱一致性迭代器
     *
     * @throws InterruptedException InterruptedException
     */
    public void weekConsistencyIterator() throws InterruptedException {
        CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<>();
        cowal.add("hello");
        cowal.add("xqk");
        cowal.add("how");
        cowal.add("are");
        cowal.add("you");
        //再修改之前获取迭代器
        Iterator<String> iterator = cowal.iterator();
        //另外一个线程里面修改List
        Thread modifyThread = new Thread(()->{
            cowal.set(1, "xjj");
            cowal.remove(2);
            cowal.remove(3);
        });
        modifyThread.start();
        //等待修改完成
        modifyThread.join();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        for (String str : cowal) {
            System.out.print(str + " ");
        }
    }
}
