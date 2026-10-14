package lab1;

// Lab 1 - Exercise 4: aliasing. PREDICT the output before you run it!
public class RectangleAliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = Rectangle.make(5, 3);

        // This copies the REFERENCE (the address), not the rectangle.
        // r1 and r2 are now two names for ONE object.
        Rectangle r2 = r1;

        r2.width = 10;    // change the object through r2

        System.out.println("r1.width = " + r1.width);   // prints 10.0, not 5.0
        System.out.println("Same object? " + (r1 == r2));
    }
}
