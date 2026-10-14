package lab5;

public class MobileMoneyPayment extends Payment {

    private final String phoneNumber;

    public MobileMoneyPayment(double amount, String phoneNumber) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void process() {
        System.out.println("Requesting " + amount + " from mobile wallet " + phoneNumber);
    }
}
