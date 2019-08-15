package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * LocalDateTimeTest
 * <p>
 * LocalDate不可变，仅仅表示日期，并且不带时区，
 *
 * @author 熊乾坤
 */
@Slf4j
class LocalDateTimeTest {


    @Test
    void testCreateLocalDate() {
        //创建当前时间
        LocalDate.now();

        //使用of创建LocalDate对象
        LocalDate localDate1 = LocalDate.of(2019, 8, 14);
        LocalDate localDate2 = LocalDate.of(2019, Month.AUGUST, 14);
        assertEquals(localDate1, localDate2);

        //使用parse方法构建LocalDate,注意，MM需要在月份前面加0,特别注意
        LocalDate localDate3 = LocalDate.parse("2019-08-14", new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").toFormatter());
        LocalDate localDate4 = LocalDate.parse("2019-08-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDate5 = LocalDate.parse("2019-08-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertEquals(localDate3, localDate4);
        assertEquals(localDate3, localDate5);

        //LocalDate默认支持的格式为yyyy-MM-dd,其他格式会抛出DateTimeParseException
        LocalDate localDate7 = LocalDate.parse("2019-08-15");
        log.info(localDate7.toString());


        //使用DayOfYear创建LocalDate
        LocalDate localDate6 = LocalDate.ofYearDay(2019, LocalDate.now().getDayOfYear());
        assertEquals(LocalDate.now(), localDate6);
    }

    @Test
    void testCreateLocalDateTime() {
        LocalDateTime ldt1 = LocalDateTime.of(2019, 8, 15, 10, 3, 20);
        LocalDate ld = LocalDate.of(2019, 8, 15);
        LocalTime lt = LocalTime.of(10, 3, 20);
        LocalDateTime ldt2 = LocalDateTime.of(ld, lt);
        assertEquals(ldt1, ldt2);
    }

    @Test
    void testGetField() {
        //通过get方法和枚举类ChronoField获取字段
        LocalDate localDate = LocalDate.now();
        int year = localDate.get(ChronoField.YEAR);
        int month = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.get(ChronoField.DAY_OF_MONTH);
        log.info("{}-{}-{}", year, month, day);
    }

    /**
     * 因为时间类是不可变的，可以通过with方法获取某个域修改之后的对象。
     */
    @Test
    void testModifyField() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.withYear(2020);
        log.info(localDate.toString());
        log.info(localDate1.toString());
        log.info(localDate.with(ChronoField.DAY_OF_MONTH, 1).toString());

        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.withHour(11);
        log.info(localTime.toString());
        log.info(localTime1.toString());
        log.info(localTime.with(ChronoField.HOUR_OF_DAY, 1).toString());
    }

    @Test
    void testFormat() {
        // 格式化和自定义格式化,星期为E
        LocalDateTime date = LocalDateTime.now();
        log.info(date.format(DateTimeFormatter.ISO_DATE));
        log.info(date.format(DateTimeFormatter.ofPattern("你好，现在是北京时间 YYYY年MM月dd日 HH点mm分ss秒 E")));

        // 使用parse将字符串转换为对象,注意时间必须要是大写的HH，喵了个咪的
        String dateString = "2019-01-02";
        String dateTimeString = "2019-01-02 10:02:03";
        LocalDate localDateParse = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime localDateTimeParse = LocalDateTime.parse(dateTimeString,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info(localDateParse.toString());
        log.info(localDateTimeParse.toString());
    }
}