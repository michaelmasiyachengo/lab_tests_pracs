package lab3;

import java.util.ArrayList;
import java.util.List;

// Lab 3 - Exercise 4: an immutable class (its objects can never change after they are created)
public final class ImmutablePerson {                 // (1) final class: nobody can extend it and add setters

    private final String name;                       // (2) private final fields: set once, in the constructor
    private final int age;
    private final List<String> hobbies;              // a List is mutable, so it needs extra care (see 4 and 5)

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        if (name == null || name.isBlank()) {        // (3) validate once, here; it stays valid forever
            throw new IllegalArgumentException("Name is required");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name.trim();
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);     // (4) defensive copy IN: later changes to the caller's list cannot reach us
    }

    public String getName() { return name; }         // (6) getters only, no setters
    public int getAge()     { return age; }

    public List<String> getHobbies() {
        return List.copyOf(hobbies);                 // (5) defensive copy OUT: callers get a read-only copy
    }

    // "Changing" a person means making a NEW person
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge, hobbies);
    }

    @Override
    public String toString() {
        return name + " (" + age + "), hobbies: " + hobbies;
    }

    public static void main(String[] args) {
        List<String> myHobbies = new ArrayList<>();
        myHobbies.add("football");
        ImmutablePerson p = new ImmutablePerson("Rudo", 20, myHobbies);

        myHobbies.add("chess");                      // changing OUR list does not change the person
        System.out.println(p);

        ImmutablePerson older = p.withAge(21);       // returns a new object
        System.out.println(p);
        System.out.println(older);
    }
}
