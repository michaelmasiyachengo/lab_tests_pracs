package lab5;

public class Child extends Parent {
    String label = "Child field";            // HIDES the parent's field (does not replace it)

    @Override
    String getLabel() {
        return "Child method";               // OVERRIDES the parent's method
    }
}
