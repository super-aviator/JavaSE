package com.xqk.learn.javase.concurrent.cachecoherence;

/**
 * @author 熊乾坤
 * @date 2020-07-16 16:43
 */
public interface IntGenerator {
    /**
     * 停止整数生成器
     */
    void cancel();

    /**
     * 判断整数生成器是否停止
     *
     * @return true或者false
     */
    boolean canceled();

    /**
     * 获取下一个生成的整数
     *
     * @return 生成的整数
     */
    int next();
}
