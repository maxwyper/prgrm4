
import java.util.Scanner;

public class CheckOut {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;
        boolean hasMoreItems = true;

        // Loop to input item prices until the user is done
        while (hasMoreItems) {
            // Get the price of the item
            double itemPrice = getRangedDouble(scanner, "Enter the price of the item ($0.50 - $10.00): ", 0.50, 10.00);
            totalCost += itemPrice;

            // Ask the user if they have more items
            hasMoreItems = getYNConfirm(scanner, "Do you have more items? (Y/N): ");
        }

        // Display the total cost
        System.out.printf("The total cost of your items is: $%.2f\n", totalCost);
    }

    // Method to get a double within a specified range
    public static double getRangedDouble(Scanner scanner, String prompt, double min, double max) {
        double input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Please enter a price between $" + min + " and $" + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }
    }

    // Method to ask a yes/no question and return a boolean
    public static boolean getYNConfirm(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String response = scanner.nextLine().toUpperCase();
            if (response.equals("Y")) {
                return true;
            } else if (response.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }
    }
}
