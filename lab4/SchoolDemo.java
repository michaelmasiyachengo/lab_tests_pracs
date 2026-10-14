package lab4;

// Lab 4 - Exercises 1 and 2: Student and Teacher share the Person code
public class SchoolDemo {
    public static void main(String[] args) {
        Person p = new Person("Chipo", 40);
        Student s = new Student("Tariro", 19, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Mathematics");

        System.out.println("--- display() written once in Person ---");
        p.display();
        s.display();       // inherited: Student has no display() of its own
        t.display();       // inherited: neither does Teacher

        System.out.println("--- extra things each subclass adds ---");
        System.out.println(s.getName() + " studies " + s.getCourse());
        System.out.println(t.getName() + " teaches " + t.getSubject());

        // Both can be used wherever a Person is expected
        Person[] everyone = { p, s, t };
        System.out.println("--- loop over Person[] ---");
        for (Person person : everyone) {
            person.display();
        }
    }
}
