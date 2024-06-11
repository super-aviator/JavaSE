package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * InstantTest
 * <p>
 * Instant是机器使用的带时区的类，他表示从Unix时间（UTC时区1979-1-1 00:00:00）开始所经过的秒数
 *
 * @author 熊乾坤
 */
@Slf4j
class InstantTest {

    @Test
    void testCreateInstant() {
        //可以直接使用系统的毫秒时间创建Instant对象
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        log.info(instant.atZone(ZoneId.of("GMT+8")).toString());

        Long currentImtMillis = System.currentTimeMillis();
//        从System.currentTimeMillis()创建Instant
        Instant instant0 = Instant.ofEpochMilli(currentImtMillis / 1000 * 1000);
//        需要转换为东八区，因为上海使用的是东八区的时间
        log.info(instant0.atZone(ZoneId.of("GMT+8")).toString());
//        使用ofEpochSecond方法从秒级别的数据创建Instant
        Instant instant1 = Instant.ofEpochSecond(currentImtMillis / 1000);
        log.info(instant1.atZone(ZoneId.of("GMT+8")).toString());
        assertEquals(instant0, instant1);
    }
}