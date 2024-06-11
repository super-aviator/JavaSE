package com.xqk.learn.javase.virtualmachine.invokedynamic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * CallGrandMethod
 *
 * @author xiongqiankun
 * @since 2022/1/22 10:46
 */
public class CallGrandMethod {
    static class GrandFather {
        public void thinking() {
            System.out.println("i am grand father");
        }
    }

    static class Father extends GrandFather {
        @Override
        public void thinking() {
            System.out.println("i am father");
        }
    }

    static class Sun extends Father {
        @Override
        public void thinking() {
            //调用GrandFather
            var mt = MethodType.methodType(void.class);
            try {
                var field = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                field.setAccessible(true);
                var mh = ((MethodHandles.Lookup) field.get(null)).findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        /*public void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                lookupImpl.setAccessible(true);
                java.lang.invoke.MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }*/

        public static void main(String[] args) {
            var sun = new Sun();
            sun.thinking();
        }
    }
}
