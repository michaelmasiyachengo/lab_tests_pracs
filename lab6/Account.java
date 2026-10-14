package lab6;

// Lab 6 - Exercise 3: abstract class with shared state and code + one abstract method
public abstract class Account {

    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    // Concrete: identical for every kind of account
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // Abstract: every account type charges a DIFFERENT fee
    public abstract double monthlyFee();

    // Concrete method that USES the abstract one (the parent does not know which fee it will get)
    public void applyMonthlyFee() {
        balance -= monthlyFee();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("%s %s balance: %.2f", getClass().getSimpleName(), accountNumber, balance);
    }
}
