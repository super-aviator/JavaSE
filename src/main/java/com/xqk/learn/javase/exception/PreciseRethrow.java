package com.xqk.learn.javase.exception;

import com.xqk.learn.javase.exception.exceptions.DerivedException;
import com.xqk.learn.javase.exception.exceptions.OriginalException;

/**
 * 更精准的重新抛出异常
 * 在 Java 7 之前，如果遇到异常，则只能重新抛出该类型的异常。这导致在 Java 7 中修复的代码不精确。
 * 所以在 Java 7 之前，这无法编译：
 * <p>
 * 因为 catch 捕获了一个 BaseException，编译器强迫你声明 catcher() 抛出 BaseException，即使它
 * 实际上抛出了更具体的 DerivedException。从 Java 7 开始，这段代码就可以编译，这是一个很小但很有
 * 用的修复。
 *
 * @author 熊乾坤
 * @date 2020-02-04 12:05
 */
public class PreciseRethrow {
    public static void main(String[] args) {

    }

    private void f() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (OriginalException e) {
            //虽然捕获了基础异常，但是依旧可以抛出更加具体的异常
            throw new DerivedException();
        }
    }
}
