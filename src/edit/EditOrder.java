package edit;

import order.FoodOrder;
import quantity.QuantityManager;

import java.util.Scanner;

public class EditOrder {

    public static void edit(
            FoodOrder order,
            Scanner scanner) {

        if (order.isEmpty()) {

            System.out.println(
                "Your order is empty."
            );

            return;
        }

        order.displayOrder();

        System.out.print(
            "Enter item number to edit: "
        );

        int choice = scanner.nextInt();

        if (choice >= 1 &&
            choice <= order.getFoods().size()) {

            int quantity =
                QuantityManager.getQuantity(scanner);

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