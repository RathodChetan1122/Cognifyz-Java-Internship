import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user input
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        // Clean the input: remove non-alphabetic characters and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Check if palindrome
        boolean isPalindrome = true;
        int length = cleanedInput.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }

        scanner.close();
    }
}
