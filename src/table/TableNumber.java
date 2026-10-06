package table;

import java.util.Scanner;

/**
 * Handles table number selection and validation for dine-in orders.
 */
public class TableNumber {

    /**
     * Prompts the user to enter a table number and ensures it is valid.
     */
    public static int getTableNumber(Scanner scanner) {

        int table;

        // Loop until a valid positive table number is provided
        while (true) {

            System.out.print("Enter table number: ");

            // Read table number input from user
            table = scanner.nextInt();

            // Validate that table number is positive
            if (table > 0) {
                return table;
            }

            // Display error message for non-positive input
            System.out.println("Invalid table number.");
        }
    }
}