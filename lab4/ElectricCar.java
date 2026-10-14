package lab4;

// Level 3: ElectricCar extends Car extends Vehicle
public class ElectricCar extends Car {

    private final int batteryKwh;

    public ElectricCar(String brand, int doors, int batteryKwh) {
        super(brand, doors);        // Car runs first (and Car runs Vehicle first)
        this.batteryKwh = batteryKwh;
        System.out.println("3. ElectricCar constructor (battery = " + batteryKwh + " kWh)");
    }

    public int getBatteryKwh() {
        return batteryKwh;
    }
}
