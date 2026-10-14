package lab3;

public class TemperatureDemo {
    public static void main(String[] args) {
        // Version 1: Kelvin inside
        Temperature a = new Temperature(25);
        System.out.println("Kelvin version:     " + a + "   getCelsius() = " + a.getCelsius());

        // Version 2: Fahrenheit inside. The calling lines are IDENTICAL, only the class name differs.
        TemperatureFahrenheit b = new TemperatureFahrenheit(25);
        System.out.println("Fahrenheit version: " + b + "   getCelsius() = " + b.getCelsius());

        // Absolute zero is the lowest allowed value; anything below is rejected
        System.out.println("Absolute zero: " + new Temperature(-273.15));
        try {
            new Temperature(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
