package com.xqk.learn.javase.base.equals;

import lombok.Getter;

@Getter
public class ClassEquals {
    private int val;
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof ClassEquals) {
            ClassEquals classEquals = (ClassEquals) obj;
            return val == classEquals.getVal();
        }
        return false;
    }
}
