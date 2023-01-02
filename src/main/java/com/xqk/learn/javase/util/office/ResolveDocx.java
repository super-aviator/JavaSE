package com.xqk.learn.javase.util.office;

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
 * 使用POI库,获取docx文件中的文字、字体、颜色、文字大小等信息
 *
 * @author 熊乾坤
 * @since 2019-8-23
 */
@Slf4j
public class ResolveDocx {
    public static void main(String[] args) throws IOException {
        log.info(JSON.toJSONString(resolve(new File("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\util\\ResolveWord.docx"))));
    }

    public static JSONArray resolve(File file) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        XWPFDocument docx = new XWPFDocument(fileIn);
        List<XWPFParagraph> paras = docx.getParagraphs();
        JSONArray jsonArr = new JSONArray();
        for (XWPFParagraph paragraph : paras) {
            for (XWPFRun run : paragraph.getRuns()) {
                if (run.getText(0).isEmpty()) {
                    continue;
                }
                JSONObject jsonObj = new JSONObject(true);
                jsonObj.put("text:", run.getText(0));
                //宋体为默认为null
                String fontName = run.getFontFamily(XWPFRun.FontCharRange.eastAsia);
                if (Objects.isNull(fontName)) {
                    fontName = "宋体";
                }
                jsonObj.put("fontName:", fontName);
                jsonObj.put("fontColor:", run.getColor());
                jsonObj.put("fontSize:", run.getFontSize());
                jsonArr.add(jsonObj);
            }
        }
        return jsonArr;
    }
}
