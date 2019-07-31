package Interview.objCompare;

import java.util.Comparator;

public class Person implements Comparator<Person> {

    private int age;
    private String name;

    public Person(){

    }
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }

    public static void main(String[] args) {

        Person p1 = new Person(27, "LiuBei");
        Person p2 = new Person(25, "张飞");
        Person p3 = new Person(26, "关羽");
        System.out.println(p1.compare(p1,p2));
        System.out.println(p1.compare(p2,p3));
    }
}
