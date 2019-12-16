package com.java8.basic.objectAnalys.clone;

import java.util.Arrays;

public class Baby implements Cloneable {
    public String name;
    public int age;
    public String[] names;
    public Baby(String name, int age, String[] names) {
        this.name = name;
        this.age = age;
        this.names = names;
    }
    @Override
    public String toString() {
        return "Baby{" + "name='" + name + '\'' + ", age=" + age + ", names=" + Arrays.toString(names) + '}';
    }
    @Override
    protected Baby clone() throws CloneNotSupportedException {
        return (Baby) super.clone();
    }
}
