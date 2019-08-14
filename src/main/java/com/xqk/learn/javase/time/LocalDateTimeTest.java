package com.xqk.learn.javase.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * 包括LocalDateTime,LocalDate,LocalTime三个不可变类
 * <p>
 * LocalDateTimeTest
 *
 * @author 熊乾坤
 */
public class LocalDateTimeTest {
    private static Logger log = Logger.getLogger("LocalDateTimeTest");

    public static void main(String[] args) {

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