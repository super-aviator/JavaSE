package com.xqk.learn.javase.operator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * BooleanApplyStringTest
 * 当将boolean类型的值放到预期为String类型的值时，boolean类型的值会转换为对应的String类型值。
 *
 * @author 熊乾坤
 */
class BooleanApplyStringTest {

    @Test
    void testBooleanConcatString() {
        assertEquals("true", "" + true);
    }
}