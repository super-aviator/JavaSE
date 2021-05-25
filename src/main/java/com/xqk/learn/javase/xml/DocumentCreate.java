package com.xqk.learn.javase.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author 熊乾坤
 * @since 2019-10-23 16:09
 */
public class DocumentCreate {
    public static void main(String[] args) {
        Document root = DocumentHelper.createDocument();
        Element rootDocument = root.addElement("root");
        rootDocument.addElement("children1").setText("熊乾坤");
        rootDocument.addElement("children2").setText("xll");
        Element approperty = rootDocument.addElement("approperty");
        approperty.addAttribute("hello", "world").setText("你好，世界");
        System.out.println(root.asXML());
    }
}
