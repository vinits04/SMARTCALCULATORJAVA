import java.util.Scanner; // Importing Scanner for user input

public class SmartCalculator {

    // Method to perform addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to perform subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method to perform multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method to perform division with error handling for division by zero
    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize Scanner for input
        boolean continueCalculating = true; // Flag to determine if the program should continue

        System.out.println("Welcome to the Smart Calculator!");

        // Main program loop
        while (continueCalculating) {
            try {
                // Get the first number from the user
                System.out.print("Enter the first number: ");
                double num1 = Double.parseDouble(scanner.nextLine());

                // Get the second number from the user
                System.out.print("Enter the second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());

                // Get the operation from the user
                System.out.print("Choose an operation (+, -, *, /): ");
                char operation = scanner.nextLine().charAt(0);

                double result = 0; // Variable to store the result

                // Perform the operation based on user input
                switch (operation) {
                    case '+':
                        result = add(num1, num2);
                        break;
                    case '-':
                        result = subtract(num1, num2);
                        break;
                    case '*':
                        result = multiply(num1, num2);
                        break;
                    case '/':
                        result = divide(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operation. Please select +, -, *, or /.");
                        continue; // Skip to the next iteration of the loop
                }

                // Display the result
                System.out.println("Result: " + result);

            } catch (NumberFormatException e) {
                // Handle invalid numeric input
                System.out.println("Invalid input. Please enter numeric values.");
            } catch (ArithmeticException e) {
                // Handle arithmetic errors (e.g., division by zero)
                System.out.println(e.getMessage());
            }

            // Ask the user if they want to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            continueCalculating = choice.equals("yes");
        }

        // Exit message
        System.out.println("Thank you for using the Smart Calculator!");
        scanner.close(); // Close the Scanner
    }
} 