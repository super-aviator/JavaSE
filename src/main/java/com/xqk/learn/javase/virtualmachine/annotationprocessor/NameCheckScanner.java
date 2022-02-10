package com.xqk.learn.javase.virtualmachine.annotationprocessor;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner9;

/**
 * NameCheckScanner
 *
 * @author xiongqiankun
 * @since 2022/1/24 17:59
 */
public class NameCheckScanner extends ElementScanner9<Void,Void> {
    /**
     * 检查类名
     *
     * @param e      TypeElement
     * @param unused Void
     * @return Void
     */
    @Override
    public Void visitType(TypeElement e, Void unused) {
        return super.visitType(e, unused);
    }

    /**
     * 检查变量名
     *
     * @param e      VariableElement
     * @param unused Void
     * @return Void
     */
    @Override
    public Void visitVariable(VariableElement e, Void unused) {
        return super.visitVariable(e, unused);
    }

    /**
     * 检查方法名
     *
     * @param e      ExecutableElement
     * @param unused Void
     * @return Void
     */
    @Override
    public Void visitExecutable(ExecutableElement e, Void unused) {
        return super.visitExecutable(e, unused);
    }
}
