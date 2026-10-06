package quantity;

import java.util.Scanner;

/**
 * Utility class to manage and validate item quantity inputs.
 */
public class QuantityManager {

    /**
     * Prompts the user for a quantity input and ensures it is greater than zero.
     */
    public static int getQuantity(
            Scanner scanner) {

        int quantity;

        // Loop until a valid positive quantity is entered
        while (true) {

            System.out.print("Enter quantity: ");

            // Read user quantity input
            quantity = scanner.nextInt();

            // Validate that quantity is positive
            if (quantity > 0) {

                return quantity;
            }

            // Display error message for invalid input
            System.out.println(
                "Quantity must be greater than 0."
            );
        }
    }
}