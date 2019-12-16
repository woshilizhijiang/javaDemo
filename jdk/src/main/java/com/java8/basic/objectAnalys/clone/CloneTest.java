package com.java8.basic.objectAnalys.clone;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("person",10);
        person.names = new String[]{"qq", "www"};
        person.baby = new Baby("baby", 20, new String[]{"qqqqq", "wwwww"});
        person.names2.add("1111");
        person.names2.add("2222");

        //  对克隆后的数据进行更改
        Person clone = person.clone();
        clone.name = "person1";
        clone.age = 23;
        clone.names2.add("3333");
        clone.names = new String[]{"111", "222"};

        clone.baby.name = "baby1";
        clone.baby.names = new String[]{"ttttt"};

        System.out.println("原来： " + person.toString());
        System.out.println("克隆： " + clone.toString());

//        原来： Person{ name='person', age=10, names=[qq, www], baby=Baby{name='baby1', age=20, names=[ttttt]}, names2=[1111, 2222, 3333]}
//        克隆： Person{ name='person1', age=23, names=[111, 222], baby=Baby{name='baby1', age=20, names=[ttttt]}, names2=[1111, 2222, 3333]}
    }
}
