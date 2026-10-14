package lab7;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);

        try {
            acc.withdraw(100);
            System.out.println("Withdrew 100. " + acc);
            acc.withdraw(5000);                              // too much: throws
            System.out.println("This line is never reached");
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage());
            System.out.println("You are short by " + e.getShortfall());
        }

        System.out.println("Balance unchanged by the failed attempt: " + acc);

        try {
            acc.withdraw(-20);
        } catch (IllegalArgumentException e) {
            System.out.println("Bug caught: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Not reached for a negative amount");
        }
    }
}
