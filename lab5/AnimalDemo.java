package lab5;

// Lab 5 - Exercise 2: one Animal[] holds Cat, Cow and Duck objects (upcasting)
public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] farm = { new Cat(), new Cow(), new Duck(), new Animal() };

        for (Animal a : farm) {
            // The JVM looks at the ACTUAL object each time (dynamic method dispatch)
            System.out.println(a.getClass().getSimpleName() + " says " + a.sound());
        }
    }
}
