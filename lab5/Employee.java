package lab5;

// Lab 5 - Exercise 3: the Employee hierarchy from Lab 4 (the println lines are removed to keep the output tidy)
public class Employee {

    private final String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double calculatePay() {
        return baseSalary;
    }
}
