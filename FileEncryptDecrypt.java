import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptDecrypt {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for operation
            System.out.print("Enter 'encrypt' or 'decrypt': ");
            String choice = scanner.nextLine().toLowerCase();

            // Prompt for input file path
            System.out.print("Enter the file path (e.g., input.txt): ");
            String inputFileName = scanner.nextLine();

            File inputFile = new File(inputFileName);
            if (!inputFile.exists()) {
                System.out.println("❌ File not found!");
                return;
            }

            // Read file contents using try-with-resources
            StringBuilder content = new StringBuilder();
            try (Scanner fileScanner = new Scanner(inputFile)) {
                while (fileScanner.hasNextLine()) {
                    content.append(fileScanner.nextLine()).append("\n");
                }
            }

            // Encrypt or decrypt the content
            String result;
            if (choice.equals("encrypt")) {
                result = shiftText(content.toString(), 3); // Caesar cipher: +3
            } else if (choice.equals("decrypt")) {
                result = shiftText(content.toString(), -3); // Caesar cipher: -3
            } else {
                System.out.println("❌ Invalid choice! Use 'encrypt' or 'decrypt'.");
                return;
            }

            // Save result to new output file
            String outputFileName = choice + "_output.txt";
            try (FileWriter writer = new FileWriter(outputFileName)) {
                writer.write(result);
            }

            System.out.println("✅ Operation successful! Output saved to: " + outputFileName);

        } catch (IOException e) {
            System.out.println("⚠️ An error occurred: " + e.getMessage());
        }
    }

    // Function to shift letters using Caesar cipher logic
    public static String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char shifted = (char) ((ch - 'A' + shift + 26) % 26 + 'A');
                result.append(shifted);
            } else if (Character.isLowerCase(ch)) {
                char shifted = (char) ((ch - 'a' + shift + 26) % 26 + 'a');
                result.append(shifted);
            } else {
                result.append(ch); // Leave digits, punctuation, spaces unchanged
            }
        }

        return result.toString();
    }
}
