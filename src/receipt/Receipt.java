package receipt;

import order.FoodOrder;
import food.Food;

/**
 * Handles generating and displaying the final transaction receipt for an order.
 */
public class Receipt {

    /**
     * Prints a formatted receipt displaying order details, item breakdown, 
     * pricing totals, discount, payment amount, and change due.
     */
    public static void print(
            FoodOrder order,
            int orderNumber,
            String diningOption,
            int tableNumber,
            double discount,
            double total,
            double payment) {

        // Calculate change due to customer
        double change = payment - total;

        System.out.println("\n");
        System.out.println(
            "======================================"
        );

        System.out.println(
            "              RECEIPT"
        );

        System.out.println(
            "======================================"
        );

        // Display order metadata
        System.out.println(
            "Order Number: " + orderNumber
        );

        System.out.println(
            "Order Type: " + diningOption
        );

        // Display table number if customer chose Dine-in
        if (diningOption.equals("Dine-in")) {

            System.out.println(
                "Table Number: " + tableNumber
            );
        }

        System.out.println(
            "--------------------------------------"
        );

        // Iterate through and print each ordered item with quantity and line total
        for (int i = 0;
             i < order.getFoods().size();
             i++) {

            Food food =
                order.getFoods().get(i);

            int quantity =
                order.getQuantities().get(i);

            double itemTotal =
                food.getPRICE() * quantity;

            System.out.println(
                food.getNAME() +
                " x" + quantity +
                " - $" + itemTotal
            );
        }

        System.out.println(
            "--------------------------------------"
        );

        // Display summary financial totals
        System.out.println(
            "Subtotal: $" +
            order.getSubtotal()
        );

        System.out.println(
            "Discount: $" +
            discount
        );

        System.out.println(
            "Total:    $" +
            total
        );

        System.out.println(
            "Payment:  $" +
            payment
        );

        System.out.println(
            "Change:   $" +
            change
        );

        System.out.println(
            "======================================"
        );

        System.out.println(
            "       THANK YOU FOR ORDERING!"
        );

        System.out.println(
            "======================================"
        );
    }
}