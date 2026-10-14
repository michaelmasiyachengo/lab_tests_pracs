package lab5;

// Lab 5 - Exercise 5 (Challenge): the base class for payments
public class Payment {

    protected final double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    // Used by design 2 (polymorphic). Each subclass overrides it.
    public void process() {
        System.out.println("Processing generic payment of " + amount);
    }
}
