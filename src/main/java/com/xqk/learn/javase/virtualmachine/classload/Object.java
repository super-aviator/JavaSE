package com.xqk.learn.javase.virtualmachine.classload;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

/**
 * Object
 *
 * @author xiongqiankun
 * @since 2022/1/15 15:26
 */
@Slf4j
public class Object {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var myCl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    var filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    var is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (Exception e) {
                    log.error("", e);
                    throw new ClassNotFoundException();
                }
            }
        };
        var myObj = myCl.loadClass("com.xqk.learn.javase.virtualmachine.classload.Object")
                        .getDeclaredConstructor()
                        .newInstance();
        System.out.println(myObj.getClass() == Object.class);
    }
}
