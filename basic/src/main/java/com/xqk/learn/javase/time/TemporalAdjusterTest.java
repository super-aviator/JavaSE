package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjusters类中封装了常用的TemporalAdjuster方法，可以使用。
 *
 * @author 熊乾坤
 */
@Slf4j
public class TemporalAdjusterTest {
    /**
     * 编写一个TemporalAdjuster，返回的时间的是该天往后的工作日（非周六周日）
     *
     * @param args args
     */
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 8, 2).with((t) -> {
            int dayOfWeek = t.get(ChronoField.DAY_OF_WEEK);
            int plusDay = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY.getValue()) {
                plusDay = 3;
            }
            if (dayOfWeek == DayOfWeek.SATURDAY.getValue()) {
                plusDay = 2;
            }
            return t.plus(plusDay, ChronoUnit.DAYS);
        });
        log.info(localDate.toString());

        TemporalAdjuster ta1 = (t) -> {
            int dayOfWeek = t.get(ChronoField.DAY_OF_WEEK);
            int plusDay = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY.getValue()) {
                plusDay = 3;
            }
            if (dayOfWeek == DayOfWeek.SATURDAY.getValue()) {
                plusDay = 2;
            }
            return t.plus(plusDay, ChronoUnit.DAYS);
        };

        //通过TemporalAdjusters中的方法包装自定义的TemporalAdjuster
        TemporalAdjuster ta2 = TemporalAdjusters.ofDateAdjuster((t) -> {
            int dayOfWeek = t.get(ChronoField.DAY_OF_WEEK);
            int plusDay = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY.getValue()) {
                plusDay = 3;
            }
            if (dayOfWeek == DayOfWeek.SATURDAY.getValue()) {
                plusDay = 2;
            }
            return t.plus(plusDay, ChronoUnit.DAYS);
        });
    }
}
