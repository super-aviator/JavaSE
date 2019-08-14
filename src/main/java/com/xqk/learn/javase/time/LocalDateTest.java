package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * LocalDateTest
 * <p>
 * LocalDate仅仅表示日期，并且不带时区，
 *
 * @author 熊乾坤
 */
@Slf4j
class LocalDateTest {


    @Test
    void createTest() {
        //创建当前时间
        LocalDate.now();

        //使用of创建LocalDate对象
        LocalDate localDate1 = LocalDate.of(2019, 8, 14);
        LocalDate localDate2 = LocalDate.of(2019, Month.AUGUST, 14);
        Assertions.assertEquals(localDate1, localDate2);

        //使用parse方法构建LocalDate,注意，MM需要在月份前面加0
        LocalDate localDate3 = LocalDate.parse("2019-08-14", new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").toFormatter());
        LocalDate localDate4 = LocalDate.parse("2019-08-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDate5 = LocalDate.parse("2019-08-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Assertions.assertEquals(localDate3, localDate4);
        Assertions.assertEquals(localDate3, localDate5);

    }
}