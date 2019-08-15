package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * ZonedDateTimeDemoTest
 *
 * ZonedDateTime表示带时区的LocalDateTime,其中包含了时区的信息
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
        log.info(zdt.toString());

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