package discount;

import java.util.Scanner;

/**
 * Handles discount calculations based on user-selected options.
 */
public class Discount {

    /**
     * Prompts the user to select a discount category and calculates the discount amount.
     */
    public static double getDiscount(
            Scanner scanner,
            double subtotal) {

                
        // Display available discount menu

        System.out.println("\n========== DISCOUNT ==========");
        System.out.println("1. Senior Citizen - 20%");
        System.out.println("2. PWD - 20%");
        System.out.println("3. Promo - 10%");
        System.out.println("4. Promo - 20%");
        System.out.println("5. No Discount");
        System.out.print("Choose discount: ");

        // Read user menu selection
        int choice = scanner.nextInt();

        double discountRate = 0;

        // Determine discount rate based on user input
        switch (choice) {

            case 1:
                discountRate = 0.20; // 20% Senior Citizen discount
                break;

            case 2:
                discountRate = 0.20; // 20% PWD discount
                break;

            case 3:
                discountRate = 0.10; // 10% Promo discount
                break;

            case 4:
                discountRate = 0.20; // 20% Promo discount
                break;

            case 5:
                discountRate = 0;    // No discount
                break;

            default:
                System.out.println(
                    "Invalid choice. No discount applied."
                );
        }

        // Calculate and return total monetary discount amount
        return subtotal * discountRate;
    }
}