package lab6;

import java.util.Comparator;

// A SECOND ordering, kept in its own class: highest marks first
public class MarksComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(b.getMarks(), a.getMarks());   // b first = descending
    }
}
