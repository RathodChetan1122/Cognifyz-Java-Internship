import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        double convertedTemp;
        if (unit == 'C') {
            // Convert Celsius to Fahrenheit
            convertedTemp = (temperature * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + convertedTemp + " °F");
        } else if (unit == 'F') {
            // Convert Fahrenheit to Celsius
            convertedTemp = (temperature - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + convertedTemp + " °C");
        } else {
            System.out.println("Invalid unit entered. Please enter 'C' or 'F'.");
        }

        scanner.close();
    }
}
