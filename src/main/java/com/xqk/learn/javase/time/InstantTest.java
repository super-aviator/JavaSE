package com.xqk.learn.javase.time;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.logging.Logger;

/**
 * InstantTest
 *
 * @author 熊乾坤
 */
public class InstantTest {
    static Logger log = Logger.getLogger("InstantTest");

    public static void main(String[] args) {
        Instant myInstant = Instant.ofEpochMilli(System.currentTimeMillis());
        myInstant.atOffset(ZoneOffset.of("+08:00"));
        log.info(myInstant.toString());
    }
}