package lab1;

// Lab 1 - Exercise 3: Rectangle with area() and perimeter()
public class Rectangle {

    double width;
    double height;

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }

    // Small helper so we can create a rectangle in one line
    static Rectangle make(double width, double height) {
        Rectangle r = new Rectangle();
        r.width = width;
        r.height = height;
        return r;
    }

    public static void main(String[] args) {
        // An array of 5 references (all start as null until we fill them)
        Rectangle[] shapes = new Rectangle[5];
        shapes[0] = make(2, 3);
        shapes[1] = make(5, 4);
        shapes[2] = make(10, 1);
        shapes[3] = make(6, 6);
        shapes[4] = make(3, 7);

        // Find the rectangle with the largest area
        Rectangle largest = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].area() > largest.area()) {
                largest = shapes[i];
            }
        }

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Rectangle " + (i + 1) + ": " + shapes[i].width + " x " + shapes[i].height
                    + "  area = " + shapes[i].area() + "  perimeter = " + shapes[i].perimeter());
        }
        System.out.println("Largest: " + largest.width + " x " + largest.height + " (area " + largest.area() + ")");
    }
}
