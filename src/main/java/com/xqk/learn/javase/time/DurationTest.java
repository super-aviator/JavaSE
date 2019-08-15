package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 熊乾坤
 */
@Slf4j
class DurationTest {

    /**
     * Duration表示一段时间间隔，可以使用静态方法去创建两个LocalDateTime、LocalTime、Instant之间的间隔
     * 值得注意的是Duration不能表示两个LocalDate之间的间隔,否则会抛UnsupportedTemporalTypeException异常？？？
     */
    @Test
    void testCreateDuration() {
        LocalDateTime ld1 = LocalDateTime.of(2019, 8, 1, 10, 10, 10);
        LocalDateTime ld2 = LocalDateTime.of(2019, 8, 15, 9, 10, 10);
        Duration duration = Duration.between(ld1, ld2);
        log.info(String.valueOf(duration.toDays()));
        log.info(String.valueOf(duration.toHours()));
    }
}
