package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Lab 8 - Exercise 1: sum, maximum and reverse order of 10 integers
public class NumberList {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();     // program to the interface: the variable is a List
        int[] values = {14, 3, 27, 8, 19, 42, 5, 31, 22, 11};
        for (int v : values) {
            numbers.add(v);                            // autoboxing: int -> Integer
        }

        int sum = 0;
        int max = numbers.get(0);
        for (int n : numbers) {
            sum = sum + n;
            if (n > max) {
                max = n;
            }
        }

        System.out.println("List:    " + numbers);
        System.out.println("Sum:     " + sum);
        System.out.println("Maximum: " + max);

        // Reverse a COPY so the original stays in order
        List<Integer> reversed = new ArrayList<>(numbers);
        Collections.reverse(reversed);
        System.out.println("Reverse: " + reversed);
    }
}
