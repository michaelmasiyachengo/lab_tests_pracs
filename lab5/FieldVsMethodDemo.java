package lab5;

public class FieldVsMethodDemo {
    public static void main(String[] args) {
        Parent p = new Child();          // declared type: Parent. Actual object: Child.

        System.out.println(p.getLabel());   // method: decided by the ACTUAL object
        System.out.println(p.label);        // field:  decided by the DECLARED type

        Child c = new Child();
        System.out.println(c.label);        // same object, but now the declared type is Child
    }
}
