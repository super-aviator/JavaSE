package com.xqk.learn.javase.time.TimeTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author 熊乾坤
 * @since 2019-11-22 9:45
 */
@Slf4j
public class TimeIntervalValidatedTest {
    public static String dateIntervalValidated(Date startDate, Date endDateTime, Integer intervalDays) {
        LocalDateTime start = LocalDateTime.ofInstant(Instant.ofEpochMilli(startDate.getTime()), ZoneId.of("GMT+8"));
        Instant expectInstant = start.toInstant(ZoneOffset.of("+8")).plus(intervalDays, ChronoUnit.DAYS);
        if (expectInstant.isBefore(Instant.ofEpochMilli(endDateTime.getTime()))) {
            return "开始时间和结束时间之间的间隔不能超过" + intervalDays + "天！";
        }
        return null;
    }

    @Test
    public void test() {
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 11, 21, 0, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2019, 11, 29, 0, 0, 0);
        log.info(dateIntervalValidated(Date.from(localDateTime1.toInstant(ZoneOffset.ofHours(8))), Date.from(localDateTime2.toInstant(ZoneOffset.ofHours(8))), 8));
    }


    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(localDateTime.plusDays(-1).toString());
    }
}
