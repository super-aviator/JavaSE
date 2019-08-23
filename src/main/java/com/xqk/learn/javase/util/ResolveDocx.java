package com.xqk.learn.javase.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * 使用POI,获取docx文件的文字、字体、颜色信息
 *
 * @author 熊乾坤
 * @date 2019-8-23
 */
@Slf4j
public class ResolveDocx {
    public static void main(String[] args) throws IOException {
        log.info(JSON.toJSONString(resolve(new File("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\util\\ResolveWordTest.docx"))));
    }

    static JSONArray resolve(File file) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        XWPFDocument docx = new XWPFDocument(fileIn);
        List<XWPFParagraph> parags = docx.getParagraphs();
        JSONArray jsonArr = new JSONArray();
        for (XWPFParagraph paragraph : parags) {
            for (XWPFRun run : paragraph.getRuns()) {
                JSONObject jsonObj = new JSONObject(true);
                log.info("text: " + run.getText(0));
                jsonObj.put("text:", run.getText(0));
                log.info("color: " + run.getColor());
                jsonObj.put("color:", run.getColor());
                //宋体为默认为null
                String fontName = run.getFontName();
                log.info("fontName: " + fontName);
                if (Objects.isNull(fontName)) {
                    fontName = "宋体";
                }
                jsonObj.put("fontName:", fontName);
                log.info("fontSize: " + run.getFontSize());
                jsonObj.put("fontSize:", run.getFontSize());
                jsonArr.add(jsonObj);
            }
        }
        return jsonArr;
    }
}
