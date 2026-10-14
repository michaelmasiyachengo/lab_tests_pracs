package lab6;

// Without the hello() below this class would NOT compile:
//   "types Greeter1 and Greeter2 are incompatible; class BothGreeter inherits unrelated defaults for hello()"
public class BothGreeter implements Greeter1, Greeter2 {

    @Override
    public void hello() {
        Greeter1.super.hello();       // choose one parent's version explicitly...
        Greeter2.super.hello();       // ...or call both, or write brand-new behaviour
        System.out.println("Hello from BothGreeter itself");
    }

    public static void main(String[] args) {
        new BothGreeter().hello();
    }
}
