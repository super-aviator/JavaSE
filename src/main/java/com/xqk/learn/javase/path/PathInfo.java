package com.xqk.learn.javase.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 熊乾坤
 * @date 2019/9/23 19:04
 */
public class PathInfo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\stream\\test.txt");

        System.out.println(System.getProperties());

        //endWith方法比较的是整个路径而不包含文件的后缀
        System.out.println(path.endsWith(".txt"));
        //正确的使用方法
        System.out.println(path.endsWith("test.txt"));
        //根据文档说明，对于文件路径：abc\\def,endWith可以匹配def\\,但是不能匹配\\def，后者是一个绝对路径
        System.out.println(path.endsWith("stream\\test.txt"));
        //获取路径的某个部分
        System.out.println(path.getName(1));
        //删除操作只支持删除单个文件或者空文件夹
        Files.delete(Paths.get("C:\\Users\\熊乾坤\\Desktop\\MouseWithoutBorders\\"));
    }
}
