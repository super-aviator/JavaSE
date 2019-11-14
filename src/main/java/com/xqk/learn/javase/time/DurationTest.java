package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 熊乾坤
 */
@Slf4j
class DurationTest {

    /**
     * Duration表示一段时间间隔（而非时间间隔，时间间隔要使用Period类），可以使用静态方法去创建两个LocalDateTime、LocalTime、Instant之间的间隔
     * 值得注意的是Duration不能表示两个LocalDate之间的间隔,这是由Period类实现的,否则会抛UnsupportedTemporalTypeException异常？？？
     */
    @Test
    void testCreateDuration() {
        LocalDateTime ld1 = LocalDateTime.of(2019, 8, 1, 10, 10, 10);
        LocalDateTime ld2 = LocalDateTime.of(2019, 8, 15, 9, 10, 10);
        Duration duration = Duration.between(ld1, ld2);
        log.info(String.valueOf(duration.toDays()));
        log.info(String.valueOf(duration.toHours()));

        // 这段时间的总天数
        long days = duration.toDays();
        // 这段时间的小时数
        long hours = duration.toHours();
        // 这段时间的分钟数
        long minutes = duration.toMinutes();
        // 这段时间的秒数
        long seconds = duration.getSeconds();
        // 这段时间的毫秒数
        long milliSeconds = duration.toMillis();
        // 这段时间的纳秒数
        long nanoSeconds = duration.toNanos();

        /*
         * Duration对象还可以通过of()方法创建，该方法接受一个时间段长度，和一个时间单位作为参数：
         */
        // 5天的Duration
        Duration duration1 = Duration.of(5, ChronoUnit.DAYS);
        // 1000毫秒的Duration
        Duration duration2 = Duration.of(1000, ChronoUnit.MILLIS);
    }
}
