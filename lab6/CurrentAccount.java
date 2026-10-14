package lab6;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double monthlyFee() {
        return 10.00;         // higher fee
    }
}
