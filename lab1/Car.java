package lab1;

import java.time.LocalDate;

// Lab 1 - Exercises 1 and 2: the Car class
public class Car {

    // Instance variables = the STATE of every Car object
    String brand;
    int year;
    int mileage;

    // Instance method = BEHAVIOUR: prints this car's details
    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }

    // Exercise 2: a car is an antique when it is MORE than 25 years old
    boolean isAntique() {
        int currentYear = LocalDate.now().getYear();   // today's year from the computer's clock
        int age = currentYear - year;
        return age > 25;
    }

    public static void main(String[] args) {
        // Exercise 1: create three cars and print them
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.year = 1988;
        car1.mileage = 250000;

        Car car2 = new Car();
        car2.brand = "Mazda";
        car2.year = 2015;
        car2.mileage = 90000;

        Car car3 = new Car();
        car3.brand = "Honda";
        car3.year = 2020;
        car3.mileage = 35000;

        car1.display();
        car2.display();
        car3.display();

        // Exercise 2: test isAntique()
        System.out.println(car1.brand + " antique? " + car1.isAntique());
        System.out.println(car2.brand + " antique? " + car2.isAntique());
        System.out.println(car3.brand + " antique? " + car3.isAntique());
    }
}
