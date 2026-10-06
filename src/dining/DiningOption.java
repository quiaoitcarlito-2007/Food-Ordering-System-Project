package dining;

import java.util.Scanner;

/**
 * Provides utility methods to prompt and retrieve the user's dining preference.
 */
public class DiningOption {

    /**
     * Prompts the user to select between Dine-in or Takeout and returns the chosen option.
     */
    public static String choose(Scanner scanner) {

        // Keep looping until a valid option is selected
        while (true) {

            // Display order type menu
            System.out.println(
                "\n========== ORDER TYPE =========="
            );

            System.out.println("1. Dine-in");
            System.out.println("2. Takeout");

            System.out.print("Choose: ");

            // Read user choice
            int choice = scanner.nextInt();

            // Validate and return the matching dining option
            if (choice == 1) {

                return "Dine-in";

            } else if (choice == 2) {

                return "Takeout";

            } else {

                System.out.println(
                    "Invalid choice."
                );
            }
        }
    }
}