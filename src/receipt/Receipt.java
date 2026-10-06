package receipt;

import order.FoodOrder;
import food.Food;

public class Receipt {

    public static void print(
            FoodOrder order,
            int orderNumber,
            String diningOption,
            int tableNumber,
            double discount,
            double total,
            double payment) {

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

        System.out.println(
            "Order Number: " + orderNumber
        );

        System.out.println(
            "Order Type: " + diningOption
        );

        if (diningOption.equals("Dine-in")) {

            System.out.println(
                "Table Number: " + tableNumber
            );
        }

        System.out.println(
            "--------------------------------------"
        );

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