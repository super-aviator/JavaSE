package com.xqk.learn.javase.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 熊乾坤
 * @since 2019/9/23 19:19
 */
public class PathForeach {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt");

        System.out.println(path.getNameCount());
        //forEach方法遍历的是不包含root路径的
        for (Path pp : path) {
            System.out.println(pp);
        }

        //通过getRoot方法来获取更路径
        System.out.println(path.getRoot());

        System.out.println("isHidden: " + Files.isHidden(path));
        System.out.println("getOwner: " + Files.getOwner(path));
        System.out.println("notExists: " + Files.notExists(path));
        System.out.println("isExecutable: " + Files.isExecutable(path));
    }
}
