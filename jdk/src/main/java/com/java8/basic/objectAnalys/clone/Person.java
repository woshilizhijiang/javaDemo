package com.java8.basic.objectAnalys.clone;

import java.util.ArrayList;
import java.util.Arrays;

public class Person implements Cloneable{
    public String name;
    public int age;
    public String[] names;
    public Baby baby;
    public ArrayList<String> names2 = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        //浅克隆  默认jdk
//        return (Person)super.clone();

        //深克隆
        Person  person = (Person)super.clone();
        person.baby = baby.clone();
        person.names2 = (ArrayList<String>) names2.clone();
        return person;

    }

    @Override
    public String toString() {
        return "Person{" +
                    " name='" + name + '\'' +
                    ", age=" + age +
                    ", names=" + Arrays.toString(names) +
                    ", baby=" + baby +
                    ", names2=" + names2
                    + '}';
    }
}
