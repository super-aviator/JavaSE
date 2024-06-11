package com.xqk.learn.javase.encrypt;

import java.util.zip.CRC32;

/**
 * @author 熊乾坤
 * @since 2019-11-19 9:53
 */
public class CRCTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CRC32 crc32 = new CRC32();
        crc32.update("asdffgsagadf阿斯顿发到付sSDFASDF鄂".getBytes());
        System.out.println(crc32.getValue());
        System.out.println(System.currentTimeMillis() - start);
    }
}
