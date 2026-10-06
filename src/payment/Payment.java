package payment;

import java.util.Scanner;

/**
 * Handles payment processing and ensures sufficient funds are provided for orders.
 */
public class Payment {

    /**
     * Prompts the user to enter a payment amount and validates that it covers the total price.
     */
    public static double processPayment(
            Scanner scanner,
            double total) {

        double payment;

        // Loop until customer provides payment equal to or greater than the order total
        while (true) {

            // Display current total due
            System.out.println(
                "\nTotal Amount: $" + total
            );

            System.out.print(
                "Enter payment: $"
            );

            // Read customer payment amount
            payment = scanner.nextDouble();

            // Return accepted payment if sufficient
            if (payment >= total) {

                return payment;
            }

            // Prompt user again if payment is insufficient
            System.out.println(
                "Insufficient payment."
            );
        }
    }
}