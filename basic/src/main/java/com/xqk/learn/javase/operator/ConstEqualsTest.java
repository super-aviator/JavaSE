package com.xqk.learn.javase.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 基本类型的包装类型和原始类型都是可以用==比较的,都放在常量池中，引用都指向同一个对象，这都有点不清楚，惭愧惭愧。
 * <p>
 * long和int会在常量池中缓存-128~+127范围的数，使用Long l = 123L或者Long l = Long.valueOf(123L)都会用到常量池中的常量
 * 但是使用new Long(123L)则不会用到常量池中的常量，而会直接在堆中创建变量
 *
 * @author 熊乾坤
 */
@Slf4j
class ConstEqualsTest {
    @Test
    void testEqual() {
        Long a = 1L;
        Long b = 1L;
        assertSame(a, b);

        Long l1 = 127L;
        Long l2 = 127L;
        assertSame(l1, l2);

        Long l3 = 128L;
        Long l4 = 128L;
        assertNotSame(l3, l4);
    }

}