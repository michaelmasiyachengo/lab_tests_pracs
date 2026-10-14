package lab7;

// Lab 7 - Exercise 2: catch ArrayIndexOutOfBoundsException
public class ArrayAccess {

    // Returns the element at the given index, or -1 if the index is outside the array
    static int getElement(int[] data, int index) {
        try {
            return data[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index " + index + ": " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        System.out.println("Element 1 = " + getElement(numbers, 1));
        System.out.println("Element 5 = " + getElement(numbers, 5));
        System.out.println("Element -1 = " + getElement(numbers, -1));
    }
}
