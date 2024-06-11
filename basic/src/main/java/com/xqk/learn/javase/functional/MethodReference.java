package com.xqk.learn.javase.functional;

import java.util.function.BiFunction;

/**
 * MethodReference
 * <p>
 * 1. 方法引用中，方法的匹配规则包含了返回值,而在方法重载中则不包含返回值（只包含参数类型，方法名，参数顺序，参数个数） 方法引用。
 * 方法匹配规则中没有包含方法名，这与匿名内部类方式不同，匿名内部类必须实现此接口，即方法签名必须完全一样。
 * 2. 方法引用是响应式的，将某个对象的方法赋值给方法引用，对象的修改会响应给方法引用。
 *
 * @author 熊乾坤
 * @since 2019-8-14
 */
public class MethodReference {

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        Callable c = ic::perform1;
        // Callable c = ic::perform2;
        c.call("xqk");
        ic.changeIdea("changed");
        c.call("xqk");
        MethodReference methodReference = new MethodReference();
        methodReference.test(MethodReference::intDouBoolMethod);
    }

    public void test(BiFunction<Integer,Double,Boolean> biFunction) {

    }

    public static Boolean intDouBoolMethod(Integer i, Double d) {
        return true;
    }

    public static class InnerClass {
        private String idea = "original";

        void changeIdea(String idea) {
            this.idea = idea;
        }

        void perform1(String msg) {
            System.out.println(idea + "---" + msg);
        }

        public String perform2(String msg) {
            System.out.println(idea + "---" + msg);
            return "";
        }
    }

    /**
     * InnerMethodReference
     */
    private interface Callable {

        void call(String str);
    }
}

/* output:
original---xqk
changed---xqk */