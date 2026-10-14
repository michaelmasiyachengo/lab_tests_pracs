package lab4;

// Lab 4 - Exercise 3: trace the order of constructor calls
public class VehicleChainDemo {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        ElectricCar tesla = new ElectricCar("Tesla", 4, 75);

        System.out.println("Done. " + tesla.getBrand() + " has " + tesla.getDoors()
                + " doors and a " + tesla.getBatteryKwh() + " kWh battery.");
    }
}
