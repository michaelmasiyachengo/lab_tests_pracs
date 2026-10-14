package lab5;

// A NEW payment type, added later to compare the two designs
public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.println("Receiving " + amount + " in cash");
    }
}
