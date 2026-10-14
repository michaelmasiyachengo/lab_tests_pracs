package lab7;

import java.util.Scanner;

// Lab 7 - Exercise 1: read two integers and divide, handling BOTH kinds of mistake
public class SafeDivide {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        try {
            System.out.print("Enter the first integer: ");
            int a = Integer.parseInt(keyboard.nextLine().trim());   // NumberFormatException if not a number

            System.out.print("Enter the second integer: ");
            int b = Integer.parseInt(keyboard.nextLine().trim());

            int result = a / b;                                     // ArithmeticException if b is 0
            System.out.println(a + " / " + b + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("That was not a whole number. Please type digits only.");
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by zero.");
        } finally {
            System.out.println("Done.");
        }
    }
}
