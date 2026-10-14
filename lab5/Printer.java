package lab5;

import java.util.Arrays;

// Lab 5 - Exercise 1: method OVERLOADING (same name, different parameters, decided at compile time)
public class Printer {

    void print(int value) {
        System.out.println("int: " + value);
    }

    void print(double value) {
        System.out.println("double: " + value);
    }

    void print(String value) {
        System.out.println("String: " + value);
    }

    void print(int[] values) {
        System.out.println("int[]: " + Arrays.toString(values));
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        p.print(42);                      // picks print(int)
        p.print(3.14);                    // picks print(double)
        p.print("hello");                 // picks print(String)
        p.print(new int[] {1, 2, 3});     // picks print(int[])
        p.print(7L);                      // a long: widened to double (the closest match that fits)
    }
}
