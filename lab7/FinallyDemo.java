package lab7;

// Lab 7 - Exercise 5 (Challenge): PREDICT the output first, then run it.
public class FinallyDemo {

    // Case 1: return inside try, print inside finally
    static int caseOne() {
        try {
            System.out.println("  try: about to return 1");
            return 1;
        } finally {
            System.out.println("  finally: still runs before the method really ends");
        }
    }

    // Case 2: finally changes the variable AFTER the return value was decided
    static int caseTwo() {
        int x = 1;
        try {
            return x;                 // the value 1 is remembered here
        } finally {
            x = 99;                   // too late to change what is returned
            System.out.println("  finally: x is now " + x);
        }
    }

    // Case 3: an exception is thrown, finally still runs, then the catch handles it
    static void caseThree() {
        try {
            System.out.println("  try: about to divide by zero");
            int r = 5 / 0;
            System.out.println("  never printed " + r);
        } catch (ArithmeticException e) {
            System.out.println("  catch: " + e.getMessage());
        } finally {
            System.out.println("  finally: runs after the catch too");
        }
    }

    public static void main(String[] args) {
        System.out.println("Case 1:");
        int a = caseOne();
        System.out.println("  returned " + a);

        System.out.println("Case 2:");
        int b = caseTwo();
        System.out.println("  returned " + b);

        System.out.println("Case 3:");
        caseThree();
    }
}
