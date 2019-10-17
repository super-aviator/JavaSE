package com.xqk.learn.javase.exception;

/**
 * 不应该在finally块中使用return语句，因为finally块中的return语句会覆盖try块中的return语句。所以最终返回的都是finally块中的return
 * 同样，在finally块中使用异常会丢失try块中抛出的非受异常（没有catch语句）
 *
 * @author 熊乾坤
 */
public class FinallyWithReturn {
    public static void main(String[] args) {
        FinallyWithReturn fwr = new FinallyWithReturn();
        System.out.println(fwr.finallyReturn());
    }

    private String finallyReturn() {
        try {
            if (Math.random() >= 0) {
                throw new RuntimeException("test");
            }
            return "try";
        } finally {
            return "finally";
        }
    }
}
