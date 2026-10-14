package lab6;

// Bird and Aeroplane share NO superclass, but both are Flyable
public class FlyDemo {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };    // program to the interface
        for (Flyable f : things) {
            f.fly();
        }
    }
}
