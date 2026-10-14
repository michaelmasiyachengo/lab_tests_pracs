package lab6;

// Lab 6 - Exercise 5 (Challenge): two interfaces with the SAME default method
public interface Greeter1 {
    default void hello() {
        System.out.println("Hello from Greeter1");
    }
}
