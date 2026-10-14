package lab5;

// Design 2: polymorphism. The processor just calls process() and each payment knows what to do.
public class PaymentProcessor2 {

    public void pay(Payment p) {
        p.process();
    }
}
