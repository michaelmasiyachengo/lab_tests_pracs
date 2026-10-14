package lab3;

import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);
        acc.deposit(250.00);
        acc.withdraw(100.00);
        acc.withdraw(5000.00);          // fails, but is still recorded
        System.out.println(acc);

        System.out.println("--- history ---");
        List<String> copy = acc.getTransactionHistory();
        for (String line : copy) {
            System.out.println(line);
        }

        // The copy cannot be changed...
        try {
            copy.clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("History copy is read-only: clear() blocked");
        }

        // ...and it is a snapshot: new transactions do not appear in the old copy
        acc.deposit(10);
        System.out.println("Old copy size: " + copy.size() + ", real history size: " + acc.getTransactionHistory().size());
    }
}
