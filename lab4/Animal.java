package lab4;

// Lab 4 - Exercise 4: an Animal with ONLY a constructor that takes a name.
// Because we wrote a constructor, Java does NOT supply a no-argument one.
public class Animal {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
