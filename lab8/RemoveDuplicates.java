package lab8;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Lab 8 - Exercise 2: a Set never holds duplicates
public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tariro");
        names.add("Farai");
        names.add("Tariro");
        names.add("Rudo");
        names.add("Farai");
        names.add("Kuda");

        // LinkedHashSet = a Set that also remembers the order things were first added.
        // (A plain HashSet would also remove duplicates but gives no order guarantee.)
        Set<String> unique = new LinkedHashSet<>(names);

        System.out.println("With duplicates:    " + names + " (" + names.size() + ")");
        System.out.println("Without duplicates: " + unique + " (" + unique.size() + ")");

        List<String> cleanList = new ArrayList<>(unique);    // back to a List if you need one
        System.out.println("As a list again:    " + cleanList);
    }
}
