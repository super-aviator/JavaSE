package com.xqk.learn.javase.util.office;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static com.xqk.learn.javase.util.office.ResolveDoc.resolveDoc;

/**
 * 将文字转换为对应的图片，图片后缀为.png
 *
 * @author 熊乾坤
 */

class FontToImage {
    /**
     * 控制行间距
     */
    private static final int LINE_INTERVAL = 10;

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\JAVASE\\src\\main\\java\\com\\xqk\\learn\\javase\\util\\ResolveWord.doc");
        createImage(resolveDoc(file), new File("E:/a.png"), 600, 500);
    }

    /**
     * 根据str,font的样式以及输出文件目录
     */
    static void createImage(JSONArray jsonArr, File outFile,
                            Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        //先用白色填充整张图片,也就是背景
        g.fillRect(0, 0, width, height);
        //用于记录每行开始写的位置的横坐标
        int drawHeight = 0;
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            Font font = new Font(jsonObj.getString("fontName"), Font.PLAIN, jsonObj.getInteger("fontSize"));
            //设置画笔字体
            g.setFont(font);
            //设置画笔颜色
            g.setColor(new Color(Integer.parseInt(jsonObj.getString("fontColor"), 16)));
            //用于获得垂直居中y
            FontMetrics fm = g.getFontMetrics(font);
            int ascent = fm.getAscent();
            int descent = fm.getDescent();
            drawHeight += (ascent + descent);

            String text = jsonObj.getString("text");
            int drawWidth = 0;
            for (char c : text.toCharArray()) {
                int charWidth = g.getFontMetrics(font).charWidth(c);
                //如果这一行写不下，则换一行写
                if (drawWidth + charWidth > width) {
                    //增加行间距
                    drawHeight += (ascent + descent);
                    //从行首开始写
                    drawWidth = 0;
                }
                g.drawString(String.valueOf(c), drawWidth, drawHeight);
                drawWidth += charWidth;
            }
            //每写完一行，增加行间距
            drawHeight += LINE_INTERVAL;
        }
        g.dispose();
        // 输出png图片
        ImageIO.write(image, "png", outFile);
    }
}
