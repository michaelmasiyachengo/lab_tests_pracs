package lab3;

// Same public methods as Temperature, but the hidden internal unit is now FAHRENHEIT.
// Nothing outside this class needs to know.
public class TemperatureFahrenheit {

    private final double fahrenheit;   // different hidden unit

    public TemperatureFahrenheit(double celsius) {
        double f = celsius * 9.0 / 5.0 + 32;
        if (f < -459.67) {             // absolute zero in Fahrenheit
            throw new IllegalArgumentException("Below absolute zero (-273.15 C) is impossible: " + celsius);
        }
        this.fahrenheit = f;
    }

    public double getCelsius() {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    @Override
    public String toString() {
        return String.format("%.2f C / %.2f F", getCelsius(), getFahrenheit());
    }
}
