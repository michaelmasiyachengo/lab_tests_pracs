package lab4;

// Level 2: Car extends Vehicle
public class Car extends Vehicle {

    private final int doors;

    public Car(String brand, int doors) {
        super(brand);               // Vehicle runs FIRST
        this.doors = doors;
        System.out.println("2. Car constructor (doors = " + doors + ")");
    }

    public int getDoors() {
        return doors;
    }
}
