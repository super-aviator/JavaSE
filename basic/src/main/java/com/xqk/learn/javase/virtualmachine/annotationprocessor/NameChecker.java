package com.xqk.learn.javase.virtualmachine.annotationprocessor;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

/**
 * NameChecker
 *
 * @author xiongqiankun
 * @since 2022/1/24 17:54
 */
public class NameChecker {
    private final Messager messager;
    private final NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    public void check(Element element) {
        nameCheckScanner.scan(element);
    }
}
