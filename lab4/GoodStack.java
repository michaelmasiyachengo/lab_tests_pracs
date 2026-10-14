package lab4;

import java.util.ArrayList;

// Lab 4 - Exercise 5 (Challenge), the RIGHT design: a Stack that HAS-A list
public class GoodStack {

    private final ArrayList<String> items = new ArrayList<>();   // hidden inside

    public void push(String item) {
        items.add(item);
    }

    public String pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public String peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
