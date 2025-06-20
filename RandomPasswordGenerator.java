import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            String numbers = "0123456789";
            String lowercase = "abcdefghijklmnopqrstuvwxyz";
            String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String specialChars = "!@#$%^&*()-_+=<>?";

            System.out.print("Enter desired password length: ");
            int length = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String allowedChars = "";

            System.out.print("Include numbers? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                allowedChars += numbers;
            }

            System.out.print("Include lowercase letters? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                allowedChars += lowercase;
            }

            System.out.print("Include uppercase letters? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                allowedChars += uppercase;
            }

            System.out.print("Include special characters? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                allowedChars += specialChars;
            }

            if (allowedChars.isEmpty()) {
                System.out.println("No character types selected. Cannot generate password.");
                return;
            }

            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(allowedChars.length());
                password.append(allowedChars.charAt(index));
            }

            System.out.println("Generated Password: " + password.toString());
        }
    }
}
