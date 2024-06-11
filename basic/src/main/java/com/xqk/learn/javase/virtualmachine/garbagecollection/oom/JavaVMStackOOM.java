package com.xqk.learn.javase.virtualmachine.garbagecollection.oom;

/**
 * -Xmx10M -Xss2M
 *
 * -Xss2M
 * @author xiongqiankun
 * @since 2021/8/22 9:11
 */
public class JavaVMStackOOM {
    public static void main(String[] args) {
        while(true){
            new Thread(()->{
                while(true){}
            }).start();
        }
    }
}
