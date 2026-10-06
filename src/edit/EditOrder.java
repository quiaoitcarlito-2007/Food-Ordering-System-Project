package edit;

import order.FoodOrder;
import quantity.QuantityManager;

import java.util.Scanner;

/**
 * Handles editing the quantities of items within an existing order.
 */
public class EditOrder {

    /**
     * Prompts the user to select an item from their order and update its quantity.
     */
    public static void edit(
            FoodOrder order,
            Scanner scanner) {

        // Check if there are any items in the order to edit
        if (order.isEmpty()) {

            System.out.println(
                "Your order is empty."
            );

            return;
        }

        // Display the current order details
        order.displayOrder();

        System.out.print(
            "Enter item number to edit: "
        );

        // Read selected item index from the user
        int choice = scanner.nextInt();

        // Validate if chosen item number is within valid range
        if (choice >= 1 &&
            choice <= order.getFoods().size()) {

            // Prompt user for new quantity
            int quantity =
                QuantityManager.getQuantity(scanner);

            // Update item quantity (converting 1-based index to 0-based array index)
            order.editQuantity(
                choice - 1,
                quantity
            );

            System.out.println(
                "Order updated successfully."
            );

        } else {

            System.out.println(
                "Invalid item number."
            );
        }
    }
}