package lab4;

import java.util.ArrayList;

// Lab 4 - Exercise 5 (Challenge), the WRONG design: a Stack that IS-A ArrayList
public class BadStack extends ArrayList<String> {

    public void push(String item) {
        add(item);                              // add to the end
    }

    public String pop() {
        return remove(size() - 1);              // remove from the end
    }
}
