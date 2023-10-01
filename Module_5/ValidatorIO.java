import java.util.Scanner;

public class ValidatorIO {
    // Static method to validate and get an integer input from the user
    public static int getInt(Scanner sc, String prompt) {
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) { // Check if the input is an integer
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value.");
            }
            sc.nextLine(); // Consume the newline character
        }
        return input;
    }

    // Static method to validate and get a double input from the user
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) { // Check if the input is a double
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value.");
            }
            sc.nextLine(); // Consume the newline character
        }
        return input;
    }

    // Static method to get a string input from the user
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }
}
