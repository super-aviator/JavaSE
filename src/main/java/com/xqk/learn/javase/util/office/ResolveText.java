package com.xqk.learn.javase.util.office;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 解析windows自带记事本中文字的文字和字体,然而字体解析不到。。。
 * 字体默认为宋体、颜色默认为红色、大小默认为你16
 *
 * @author 熊乾坤
 * @date 2019-8-23
 */
@Slf4j
public class ResolveText {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\util\\ResolveText.txt");
        log.info("*" + resolveText(file));
    }

    public static JSONArray resolveText(File file) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        List<String> strList = IOUtils.readLines(fileIn, Charset.forName("UTF-8"));
        JSONArray result = new JSONArray();
        for (String text : strList) {
            if (text.isEmpty()) {
                continue;
            }
            JSONObject jsonObj = new JSONObject(true);
            jsonObj.put("text", text);
//            字体默认为宋体
            jsonObj.put("fontName", "宋体");
//            颜色默认为红色
            jsonObj.put("fontColor", "ff0000");
//            字体大小默认为32
            jsonObj.put("fontSize", 16);
            result.add(jsonObj);
        }
        return result;
    }
}
