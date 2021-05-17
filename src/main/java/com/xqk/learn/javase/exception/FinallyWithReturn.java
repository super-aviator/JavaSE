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
        //try和finally中都有return，返回finally中的return
        System.out.println("tryReturnFinallyReturn:"+fwr.tryReturnFinallyReturn());
        //catch和finally中都有return，返回finally中的return
        System.out.println("catchReturnFinallyReturn:"+fwr.catchReturnFinallyReturn());
        System.out.println("tryReturnfinallyReturnPrime:"+fwr.tryReturnFinallyReturnPrime());
        System.out.println("finallyCatchReturn:" + fwr.finallyCatchReturn());
        System.out.println("finallyCatchReturnWithPrime:" + fwr.finallyCatchReturnWithPrime());
        System.out.println("finallyReturnWithPrime:" + fwr.finallyReturnWithPrime());
    }

    private String tryReturnFinallyReturn() {
        try{
            return "try";
        } finally {
            return "finally";
        }
    }

    private String catchReturnFinallyReturn() {
        try{
            throw new Exception();
        }catch(Exception e){
            return "catch";
        } finally {
            return "finally";
        }
    }

    private int tryReturnFinallyReturnPrime() {
        int i=0;
        try {
            i=1;
            return i;
        } finally {
            i=2;
            return i;
        }
    }

    private String finallyCatchReturn() {
        String str;
        try {
            str = "try";
//            if (str.equals("try")) {
//                throw new RuntimeException();
//            }
            return str;
        } catch (Exception e) {
            str = "catch";
            return str;
        } finally {
            str = "finally";
            return str;
        }
    }

    private int finallyCatchReturnWithPrime() {
        int i=0;
        try {
            throw new Exception();
        } catch (Exception e) {
            ++i;
            return i;
        } finally {
            ++i;
        }
    }
    private int finallyReturnWithPrime() {
        int i=0;
        try {
            i=2;
            return i;
        } finally {
            ++i;
        }
    }
}
