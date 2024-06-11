package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * ZonedDateTimeDemoTest
 *
 * ZonedDateTime表示带时区的LocalDateTime,其中包含了时区的信息
 *
 * ZoneId.of可以使用两种方式：GMT+08:00或者Asia/Shanghai
 *
 * @author 熊乾坤
 */
@Slf4j
class ZonedDateTimeDemoTest {
    @Test
    void convert() {
        //LocalDateTime->ZonedDateTime
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("GMT+8"));
        ZonedDateTime zdt1 = ldt.atZone(ZoneId.of("GMT+09:00"));
        ZonedDateTime zdt2 = ldt.atZone(ZoneId.of("Europe/Paris"));
        log.info(ldt.toString());
        log.info(zdt.toString());
        log.info(zdt1.toString());
        log.info(zdt2.toString());

        //LocalDate->ZonedDateTime
        LocalDate ld = LocalDate.now();
        zdt = ld.atStartOfDay(ZoneId.of("GMT+8"));
        log.info(zdt.toString());

        //Instant->ZonedDateTime
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        zdt = instant.atZone(ZoneId.of("GMT+8"));
        log.info(zdt.toString());

    }
}