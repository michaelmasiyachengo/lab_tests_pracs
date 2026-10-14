package lab7;

public class AgeValidator {

    // "throws" warns every caller that they must catch or declare InvalidAgeException
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException(age);
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] testAges = {25, 0, 120, -5, 121};

        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }
        // validateAge(30);   // would NOT compile here: unreported exception InvalidAgeException
    }
}
