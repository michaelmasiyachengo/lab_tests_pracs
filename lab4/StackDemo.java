package lab4;

public class StackDemo {
    public static void main(String[] args) {
        // --- Inheritance version: it works, but it LEAKS the whole ArrayList interface ---
        BadStack bad = new BadStack();
        bad.push("first");
        bad.push("second");
        bad.push("third");

        bad.add(0, "SNEAKY");          // inserts at the BOTTOM: a real stack can never do this
        bad.remove(1);                 // removes from the MIDDLE: also impossible in a real stack
        System.out.println("BadStack after sneaky calls: " + bad);
        System.out.println("BadStack pop() returned: " + bad.pop());

        // --- Composition version: only the stack operations exist ---
        GoodStack good = new GoodStack();
        good.push("first");
        good.push("second");
        good.push("third");
        // good.add(0, "SNEAKY");      // COMPILE ERROR: GoodStack has no add method
        System.out.println("GoodStack peek: " + good.peek());
        System.out.println("GoodStack pop order: " + good.pop() + ", " + good.pop() + ", " + good.pop());
        System.out.println("GoodStack empty now? " + good.isEmpty());
    }
}
