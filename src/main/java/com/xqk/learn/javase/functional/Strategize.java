package com.xqk.learn.javase.functional;

/**
 * 有点搞不懂Unrelated类的方法引用为什么可以赋值到Strategy数组中去。
 */
public class Strategize {
    private Strategy strategy;
    private String msg;

    private Strategize(String msg) {
        //[1]
        strategy = new Soft();
        this.msg = msg;
    }

    public static void main(String[] args) {
        //[2]
        Strategy[] strategies = {new Strategy() {
            @Override
            public String approach(String msg) {
                return msg.toUpperCase() + "!";
            }
        },
                //[3]
                msg -> msg.substring(0, 5),
                //[4]
                Unrelated::twice
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for (Strategy newStrategy : strategies) {
            //[5]
            s.changeStrategy(newStrategy);
            //[6]
            s.communicate();
        }
    }

    private void communicate() {
        System.out.println(strategy.approach(msg));
    }

    private void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

@FunctionalInterface
interface Strategy {
    /**
     * 函数式方法
     *
     * @param msg 参数
     * @return 返回值
     */
    String approach(String msg);
}

