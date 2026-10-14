package lab6;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double monthlyFee() {
        return 2.00;          // low fee
    }
}
