package lab8;

import java.util.ArrayList;

// Lab 8 - Exercise 3: a GENERIC stack. T is chosen by the caller: Stack<String>, Stack<Integer>, ...
public class Stack<T> {

    private final ArrayList<T> items = new ArrayList<>();     // hidden storage (composition, like Lab 4)

    public void push(T item) {
        items.add(item);                                      // top of the stack = end of the list
    }

    public T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        Stack<String> words = new Stack<>();
        words.push("first");
        words.push("second");
        words.push("third");
        System.out.println("peek: " + words.peek());
        System.out.println("pop:  " + words.pop());
        System.out.println("pop:  " + words.pop());
        System.out.println("empty? " + words.isEmpty());

        Stack<Integer> numbers = new Stack<>();     // same class, different type
        numbers.push(10);
        numbers.push(20);
        int top = numbers.pop();                    // no cast needed
        System.out.println("top number: " + top);
        // numbers.push("oops");                    // COMPILE ERROR: a String is not an Integer

        words.pop();
        try {
            words.pop();                            // nothing left
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
