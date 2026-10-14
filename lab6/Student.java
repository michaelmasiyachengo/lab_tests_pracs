package lab6;

// Lab 6 - Exercise 4: Comparable gives a class its NATURAL ordering (here: by name)
public class Student implements Comparable<Student> {

    private final String name;
    private final int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // Negative = this comes first, 0 = equal, positive = this comes after
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);      // String already knows alphabetical order
    }

    @Override
    public String toString() {
        return name + "(" + marks + ")";
    }
}
