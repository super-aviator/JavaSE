package com.xqk.learn.javase.path;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 * 文件夹-folder/directory
 * 删除文件树，使用FileVisitor接口，FileVisitor接口：
 * 1.  **preVisitDirectory()**：在访问目录中条目之前在目录上运行。
 * 2.  **visitFile()**：运行目录中的每一个文件。
 * 3.  **visitFileFailed()**：调用无法访问的文件。
 * 4.  **postVisitDirectory()**：在访问目录中条目之后在目录上运行，包括所有的子目录。
 *
 * @author 熊乾坤
 * @date 2019/9/24 13:15
 */
@Slf4j
public class DeleteDirectoryTree {
    private static void rmDir(Path path) throws IOException {
        Objects.requireNonNull(path, "文件路径不能为空");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                log.info(file.toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                log.info(dir.toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        rmDir(Paths.get("C:\\Users\\熊乾坤\\Desktop\\TestDelete\\"));
    }
}
