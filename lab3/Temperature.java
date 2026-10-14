package lab3;

// Lab 3 - Exercise 5 (Challenge): stores KELVIN inside, but callers only see Celsius and Fahrenheit
public class Temperature {

    private static final double ABSOLUTE_ZERO_KELVIN = 0.0;

    private final double kelvin;      // the hidden internal unit

    // Callers give us Celsius (the public "contract")
    public Temperature(double celsius) {
        double k = celsius + 273.15;
        if (k < ABSOLUTE_ZERO_KELVIN) {
            throw new IllegalArgumentException("Below absolute zero (-273.15 C) is impossible: " + celsius);
        }
        this.kelvin = k;
    }

    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return getCelsius() * 9.0 / 5.0 + 32;
    }

    @Override
    public String toString() {
        return String.format("%.2f C / %.2f F", getCelsius(), getFahrenheit());
    }
}
