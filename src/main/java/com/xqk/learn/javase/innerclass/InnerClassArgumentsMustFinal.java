package com.xqk.learn.javase.innerclass;

/**
 * InnerArgumentMustFinal
 * <p>
 *
 * @author 熊乾坤
 */
public class InnerClassArgumentsMustFinal {

    public static void main(String[] args) {
        InnerClassArgumentsMustFinal argumentMustFinal = new InnerClassArgumentsMustFinal();
        argumentMustFinal.genericInnerClass(10).execute();
    }

    /**
     * java对闭包的支持：方法中的匿名内部类，如果想要使用方法中传进来的参数，必须使用final修饰该参数，以保证该参数不会被改变，
     * 如果确保在内部类中，该参数没有被改变，则可以省略final。
     */
    private InnerClass genericInnerClass(int x) {
        return () -> {
//                不允许改变x的值
//                 x+=1;
            System.out.println("InnerClass.execute() " + x);
        };
    }
}

/**
 * 在接口中使用@FunctionalInterface注解申明接口为函数式接口，函数式接口内部只能有一个方法
 */
@FunctionalInterface
interface InnerClass {
    void execute();
//    void complete();
}