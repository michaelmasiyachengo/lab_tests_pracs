package lab6;

// Lab 6 - Exercise 1: an ABSTRACT class. You cannot write "new Shape()".
public abstract class Shape {

    public abstract double area();         // no body: every concrete subclass MUST provide one
    public abstract double perimeter();

    // A concrete method shared by every shape
    public void describe() {
        System.out.printf("%-10s area = %7.2f   perimeter = %6.2f%n",
                getClass().getSimpleName(), area(), perimeter());
    }
}
