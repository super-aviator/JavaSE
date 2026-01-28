package com.xqk.learn.javase.base.colne;

import lombok.Data;

/**
 * Person
 *
 * @author qiankun.xiong
 * @version 1.0.0
 * @since 2026/1/20 11:49
 */
@Data
public class Person implements Cloneable {
    private Address address;

    public Person(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        var person = (Person) super.clone();
        person.setAddress((Address) person.getAddress().clone());
        return person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        var address = new Address();
        var person = new Person(address);

        var personCopy = (Person) person.clone();
        System.out.println(personCopy == person);
        System.out.println(personCopy.getAddress() == person.getAddress());
        System.out.println(42==42.0);
    }
}
