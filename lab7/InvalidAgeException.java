package lab7;

// Lab 7 - Exercise 3: a CHECKED exception (it extends Exception, so callers must handle it)
public class InvalidAgeException extends Exception {

    private final int age;     // carries useful information about what went wrong

    public InvalidAgeException(int age) {
        super("Invalid age " + age + ": must be between 0 and 120");
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
