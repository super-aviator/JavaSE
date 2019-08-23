package com.xqk.learn.javase.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用POI,获取.doc文件的文字、字体、颜色信息
 *
 * @author 熊乾坤
 * @date 2019-8-22
 */
@Slf4j
class ResolveDoc {
    /**
     * doc文件中的换行符
     */
    private static final String SEPARATOR = "\r";

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\util\\ResolveWordTest.doc");
        log.info(resolveDoc(file).toJSONString());
    }

    static JSONArray resolveDoc(File file) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        HWPFDocument handler = new HWPFDocument(fileIn);
        Range range = handler.getRange();

        JSONArray jsonArr = new JSONArray();
        for (int i = 0; i < range.numCharacterRuns(); i++) {
            CharacterRun cr = range.getCharacterRun(i);
            String text = cr.text();
            if (text.equals(SEPARATOR)) {
                continue;
            }
            JSONObject obj = new JSONObject(true);
            //读取文字内容,删除末尾的换行符
            obj.put("text: ", StringUtils.trimWhitespace(text));
            //读取字体
            obj.put("fontName: ", cr.getFontName());
            //读取十六进制颜色,不带#
            obj.put("fontColor: ", ColorUtil.getSimpleHexColor(cr.getIco24()));
            //读取文字大小
            obj.put("fontSize: ", cr.getFontSize() / 2);

            jsonArr.add(obj);
        }
        return jsonArr;
    }
}
