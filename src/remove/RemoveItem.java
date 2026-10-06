package remove;

import order.FoodOrder;
import java.util.Scanner;

public class RemoveItem {

    public static void remove(
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
            "Enter item number to remove: "
        );

        int choice = scanner.nextInt();

        if (choice >= 1 &&
            choice <= order.getFoods().size()) {

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