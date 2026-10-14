package lab5;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentProcessor oldWay = new PaymentProcessor();
        PaymentProcessor2 newWay = new PaymentProcessor2();

        Payment[] payments = {
            new CardPayment(100, "4321"),
            new MobileMoneyPayment(25.5, "0771234567"),
            new CashPayment(10)              // the new type
        };

        for (Payment p : payments) {
            oldWay.pay(p);
            newWay.pay(p);
            System.out.println("---");
        }
    }
}
