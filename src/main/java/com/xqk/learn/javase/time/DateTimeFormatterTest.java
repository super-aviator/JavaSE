package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 和老的DateFormat相比，新的DateTimeFormat是线程安全的,可以在多个线程中使用
 *
 * @author 熊乾坤
 */
@Slf4j
class DateTimeFormatterTest {
    @Test
    void testConstFormatter() {
        LocalDate ld1 = LocalDate.now();
        log.info(DateTimeFormatter.ISO_DATE.format(ld1));
        log.info(DateTimeFormatter.BASIC_ISO_DATE.format(ld1));
    }
}
