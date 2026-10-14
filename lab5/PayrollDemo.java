package lab5;

// Lab 5 - Exercise 3: total payroll for a MIXED array. The payroll loop does not know about Intern.
public class PayrollDemo {

    // This method was written BEFORE Intern existed and is never edited afterwards
    static double totalPayroll(Employee[] staff) {
        double total = 0;
        for (Employee e : staff) {
            double pay = e.calculatePay();            // polymorphic call
            System.out.printf("%-8s %-10s %8.2f%n", e.getName(), e.getClass().getSimpleName(), pay);
            total += pay;
        }
        return total;
    }

    public static void main(String[] args) {
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Ruvimbo", 400)                // the new type just slots in
        };

        double total = totalPayroll(staff);
        System.out.printf("Total payroll: %.2f%n", total);
    }
}
