package lab6;

public class AccountDemo {
    public static void main(String[] args) {
        Account[] accounts = {
            new SavingsAccount("SAV-1", 1000),
            new CurrentAccount("CUR-1", 1000)
        };

        for (Account a : accounts) {
            a.deposit(500);
            System.out.println("Before fee: " + a);
            a.applyMonthlyFee();                 // same call, different fee
            System.out.println("After fee:  " + a + "  (fee was " + a.monthlyFee() + ")");
        }
    }
}
