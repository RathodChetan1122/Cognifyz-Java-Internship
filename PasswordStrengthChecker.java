import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user to enter a password
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Criteria flags
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            // Check each character
            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) hasUpper = true;
                else if (Character.isLowerCase(ch)) hasLower = true;
                else if (Character.isDigit(ch)) hasDigit = true;
                else if ("!@#$%^&*()-_+=<>?/".contains(String.valueOf(ch))) hasSpecial = true;
            }

            // Determine strength
            int score = 0;
            if (password.length() >= 8) score++;
            if (hasUpper) score++;
            if (hasLower) score++;
            if (hasDigit) score++;
            if (hasSpecial) score++;

            // Display strength
            System.out.println("\nPassword Strength:");

            switch (score) {
                case 5:
                    System.out.println("Very Strong ✅");
                    break;
                case 4:
                    System.out.println("Strong 💪");
                    break;
                case 3:
                    System.out.println("Moderate ⚠️");
                    break;
                case 2:
                    System.out.println("Weak ❌");
                    break;
                default:
                    System.out.println("Very Weak ❌❌");
                    break;
            }
        }
    }
}
