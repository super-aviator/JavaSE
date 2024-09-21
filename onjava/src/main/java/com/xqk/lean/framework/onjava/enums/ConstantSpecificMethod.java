package com.xqk.lean.framework.onjava.enums;

import java.time.LocalDate;

/**
 * 常量特定方法
 *
 * @author qiankun.xiong
 * @since 2023/3/5 11:14
 */
public enum ConstantSpecificMethod {
    /** 时间 */
    LOCAL_DATE {
        @Override
        String info() {
            return LocalDate.now().toString();
        }
    },
    /** 类路径 */
    CLASSPATH {
        @Override
        String info() {
            return "CLASS_PATH";
        }
    },
    /** java版本 */
    JAVA_VERSION {
        @Override
        String info() {
            return "JAVA_VERSION";
        }
    };

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.info());
        }
    }

    abstract String info();

}
