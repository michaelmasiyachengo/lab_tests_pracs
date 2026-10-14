package lab3;

// Lab 3 - Exercises 1 and 2: private fields, a validating setter, and a calculated grade
public class Student {

    private String name;
    private int marks;      // always kept between 0 and 100
    // Note: there is NO "grade" field. The grade is worked out from the marks every time.

    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);    // reuse the setter so the constructor validates too
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        this.name = name.trim();
    }

    // Exercise 1: reject invalid marks
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100, but got " + marks);
        }
        this.marks = marks;
    }

    // Exercise 2: calculated from marks, not stored.
    // (The manual does not give grade boundaries, so these are an assumption: change them to match your course.)
    public String getGrade() {
        if (marks >= 70) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {
        return name + ": " + marks + " (" + getGrade() + ")";
    }

    public static void main(String[] args) {
        Student s = new Student("Tendai", 72);
        System.out.println(s);

        s.setMarks(55);                       // marks change, so the grade changes with them
        System.out.println(s);

        try {
            s.setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        System.out.println("Marks are still " + s.getMarks());

        int[] tests = {95, 70, 69, 60, 59, 50, 49, 0};
        for (int m : tests) {
            s.setMarks(m);
            System.out.println(m + " -> " + s.getGrade());
        }
    }
}
