package com.xqk.learn.javase.concurrent.cachecoherence;

/**
 * @author 熊乾坤
 * @date 2020-07-16 17:03
 */
public class EvenGenerator implements IntGenerator {
    private volatile boolean status = true;
    private int baseNum = 0;

    public static void main(String[] args) {
        //new TimeAbort(10, "No odd number found!");
        //EvenCheck.check(new EvenGenerator(), 10);
        switch (Integer.valueOf("1")) {
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println("nothing");
        }
    }

    @Override
    public void cancel() {
        status = false;
    }

    @Override
    public boolean canceled() {
        return !status;
    }

    @Override
    public int next() {
        baseNum++;
        baseNum++;
        return baseNum;
    }
}
