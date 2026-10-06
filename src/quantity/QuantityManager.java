package quantity;

import java.util.Scanner;

public class QuantityManager {

    public static int getQuantity(
            Scanner scanner) {

        int quantity;

        while (true) {

            System.out.print("Enter quantity: ");

            quantity = scanner.nextInt();

            if (quantity > 0) {

                return quantity;
            }

            System.out.println(
                "Quantity must be greater than 0."
            );
        }
    }
}