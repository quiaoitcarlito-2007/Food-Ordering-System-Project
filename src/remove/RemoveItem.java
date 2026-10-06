package remove;

import order.FoodOrder;
import java.util.Scanner;

/**
 * Handles removing items from an existing order.
 */
public class RemoveItem {

    /**
     * Prompts the user to select an item from their order and removes it.
     */
    public static void remove(
            FoodOrder order,
            Scanner scanner) {

        // Check if there are any items in the order to remove
        if (order.isEmpty()) {

            System.out.println(
                "Your order is empty."
            );

            return;
        }

        // Display current order contents
        order.displayOrder();

        System.out.print(
            "Enter item number to remove: "
        );

        // Read user's choice of item to remove
        int choice = scanner.nextInt();

        // Validate choice against list bounds
        if (choice >= 1 &&
            choice <= order.getFoods().size()) {

            // Remove item (converting 1-based user input to 0-based array index)
            order.removeItem(choice - 1);

            System.out.println(
                "Item removed successfully."
            );

        } else {

            System.out.println(
                "Invalid item number."
            );
        }
    }
}