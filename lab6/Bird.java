package lab6;

public class Bird implements Flyable {
    @Override
    public void fly() {                       // interface methods must be public
        System.out.println("The bird flaps its wings and flies");
    }
}
