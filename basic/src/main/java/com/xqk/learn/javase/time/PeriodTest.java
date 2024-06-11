package com.xqk.learn.javase.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Period和Duration类似，不同的是Period表示的是日期间隔，而Duration表示的是时间间隔，所以Period的创建方法只能传入LocalDate对象
 *
 * @author 熊乾坤
 */
@Slf4j
class PeriodTest {
    @Test
    void testCreate() {
        Period period = Period.between(LocalDate.now(), LocalDate.of(2019, 8, 1));
        log.info(period.toString());
        //获取间隔天数
        log.info(String.valueOf(period.getDays()));
        //获取间隔月数
        log.info(String.valueOf(period.getMonths()));

        period = Period.ofDays(20);
        log.info(period.toString());

        period = Period.of(2019, 8, 11);
        log.info(period.toString());

    }
}
