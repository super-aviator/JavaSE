package com.xqk.learn.javase.base.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * MySerializableClass
 *
 * @author xiongqiankun
 * @since 2022/2/11 8:59
 */
public class MySerializableClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int i = 99;

    public static void main(String[] args) {
        try (var oos = new ObjectOutputStream(new FileOutputStream("obj.bat"))) {
            oos.writeObject(new MySerializableClass());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (var ois = new ObjectInputStream(new FileInputStream("obj.bat"))) {
            var obj = (MySerializableClass) ois.readObject();
            System.out.println(obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MySerializableClass{" +
                "i=" + i +
                '}';
    }
}
