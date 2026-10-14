package lab5;

// Design 1: instanceof pattern matching (Java 16+). The processor has to know every payment type.
public class PaymentProcessor {

    public void pay(Payment p) {
        if (p instanceof CardPayment c) {                    // test AND cast in one step
            System.out.println("[design 1] Charging card ending " + c.getCardLast4());
        } else if (p instanceof MobileMoneyPayment m) {
            System.out.println("[design 1] Requesting money from wallet " + m.getPhoneNumber());
        } else {
            System.out.println("[design 1] Unknown payment type: " + p.getClass().getSimpleName());
        }
    }
}
