package com.xqk.learn.javase.util.office;

/**
 * POI颜色转换工具类， 原作者：https://www.cnblogs.com/newcaoguo/p/6231175.html
 *
 * @author 熊乾坤
 * @since 2019-8-23
 */
class ColorUtil {

    static int red(int c) {
        return c & 0XFF;
    }

    static int green(int c) {
        return (c >> 8) & 0XFF;
    }

    static int blue(int c) {
        return (c >> 16) & 0XFF;
    }

    static int rgb(int c) {
        return (red(c) << 16) | (green(c) << 8) | blue(c);
    }

    static String rgbToSix(String rgb) {
        int length = 6 - rgb.length();
        String str = "";
        while (length > 0) {
            str += "0";
            length--;
        }
        return str + rgb;
    }

    static String getHexColor(int color) {
        color = color == -1 ? 0 : color;
        int rgb = rgb(color);
        return "#" + rgbToSix(Integer.toHexString(rgb));
    }

    static String getSimpleHexColor(int color) {
        color = color == -1 ? 0 : color;
        int rgb = rgb(color);
        return rgbToSix(Integer.toHexString(rgb));
    }
}
