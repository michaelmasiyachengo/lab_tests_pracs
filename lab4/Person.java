package lab4;

// Lab 4 - Exercise 1: the superclass
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Written ONCE here, inherited by Student and Teacher
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
