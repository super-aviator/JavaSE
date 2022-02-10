package com.xqk.learn.javase.virtualmachine.garbagecollection.oom;

import java.util.HashSet;
import java.util.UUID;

/**
 * -Xmx10m
 * @author xiongqiankun
 * @since 2021/8/22 13:44
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        while(true){
            set.add(UUID.randomUUID().toString().intern());
        }
    }
}
