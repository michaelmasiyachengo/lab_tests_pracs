package lab8;

import java.util.Arrays;

// Lab 8 - Exercise 5 (Challenge): a generic bubble sort
public class BubbleSortDemo {

    // T extends Comparable<T> means: "T can be compared with itself", so compareTo is available
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int pass = 0; pass < arr.length - 1; pass++) {
            for (int i = 0; i < arr.length - 1 - pass; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {      // out of order? swap them
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {42, 7, 19, 3, 25};
        String[] names = {"Zodwa", "Alice", "Moyo", "Chipo"};

        bubbleSort(numbers);
        bubbleSort(names);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(names));

        int[] primitives = {5, 2, 9};
        // bubbleSort(primitives);    // COMPILE ERROR: see the explanation in the lab notes
        System.out.println("int[] has to be sorted another way, e.g. Arrays.sort: " + sortedCopy(primitives));
    }

    static String sortedCopy(int[] data) {
        int[] copy = Arrays.copyOf(data, data.length);
        Arrays.sort(copy);
        return Arrays.toString(copy);
    }
}
