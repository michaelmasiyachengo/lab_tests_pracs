package lab5;

public class CardPayment extends Payment {

    private final String cardLast4;

    public CardPayment(double amount, String cardLast4) {
        super(amount);
        this.cardLast4 = cardLast4;
    }

    public String getCardLast4() {
        return cardLast4;
    }

    @Override
    public void process() {
        System.out.println("Charging " + amount + " to card ending " + cardLast4);
    }
}
