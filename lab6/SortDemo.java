package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Chenai", 82));
        students.add(new Student("Anesu", 70));
        students.add(new Student("Blessing", 95));
        students.add(new Student("Farai", 88));

        Collections.sort(students);                       // uses compareTo (by name)
        System.out.println("By name:         " + students);

        Collections.sort(students, new MarksComparator()); // uses the Comparator (by marks)
        System.out.println("By marks (high): " + students);
    }
}
