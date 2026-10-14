package lab4;

// Lab 4 - Exercise 3: level 1 of a multilevel chain
public class Vehicle {

    private final String brand;

    public Vehicle(String brand) {
        this.brand = brand;
        System.out.println("1. Vehicle constructor (brand = " + brand + ")");
    }

    public String getBrand() {
        return brand;
    }
}
