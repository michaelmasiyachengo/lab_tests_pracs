package lab4;

// Lab 4 - Exercise 1: Student IS-A Person
public class Student extends Person {

    private final String course;

    public Student(String name, int age, String course) {
        super(name, age);            // runs Person's constructor first
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
