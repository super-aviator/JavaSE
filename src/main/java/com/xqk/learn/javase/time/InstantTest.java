package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneOffset;

/**
 * InstantTest
 *
 * @author 熊乾坤
 */
@Slf4j
public class InstantTest {

    public static void main(String[] args) {
        Instant myInstant = Instant.ofEpochMilli(System.currentTimeMillis());
        myInstant.atOffset(ZoneOffset.of("+08:00"));
        log.info(myInstant.toString());
    }
}