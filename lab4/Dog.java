package lab4;

// The FIXED version of Dog: it calls super(name) explicitly.
// (See BrokenDog.txt for the version that does not compile.)
public class Dog extends Animal {

    public Dog(String name) {
        super(name);        // we must pass the name up, because Animal has no Animal() constructor
    }

    public void bark() {
        System.out.println(getName() + " says Woof");
    }

    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        d.bark();
    }
}
