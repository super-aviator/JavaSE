package com.xqk.learn.javase.path;

import java.nio.file.Paths;

/**
 * Path支持的操作。
 *
 * @author 熊乾坤
 * @date 2019/9/24 10:49
 */
public class PathOperate {
    public static void main(String[] args) {
        System.out.println(Paths.get("..", "..", "..").toAbsolutePath().normalize());
        System.out.println(Paths.get("Hello").resolve(Paths.get("World")));
        System.out.println(Paths.get("Hello\\My\\Name").resolve(Paths.get("Is\\Xqk")));
    }
}