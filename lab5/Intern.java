package lab5;

// The NEW class for Exercise 3. Nothing else in the project has to change.
public class Intern extends Employee {

    private static final double TRANSPORT_ALLOWANCE = 50.0;

    public Intern(String name, double stipend) {
        super(name, stipend);
    }

    @Override
    public double calculatePay() {
        return baseSalary + TRANSPORT_ALLOWANCE;
    }
}
