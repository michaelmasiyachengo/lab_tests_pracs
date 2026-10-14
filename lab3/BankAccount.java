package lab3;

import java.util.ArrayList;
import java.util.List;

// Lab 3 - Exercise 3: BankAccount (Program 3.1) extended with a transaction history
public class BankAccount {

    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> history = new ArrayList<>();   // private: only this class edits it

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add(String.format("Opened with %.2f", openingBalance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        history.add(String.format("Deposit %.2f", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            history.add(String.format("Failed withdrawal of %.2f (insufficient funds)", amount));
            return false;
        }
        balance -= amount;
        history.add(String.format("Withdrawal %.2f", amount));
        return true;
    }

    // Returns an unmodifiable COPY of the history.
    // List.copyOf makes a brand-new list that cannot be changed, so the caller never touches our real list.
    public List<String> getTransactionHistory() {
        return List.copyOf(history);
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}
