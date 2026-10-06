package discount;

import java.util.Scanner;

public class Discount {

    public static double getDiscount(
            Scanner scanner,
            double subtotal) {

        System.out.println("\n========== DISCOUNT ==========");
        System.out.println("1. Senior Citizen - 20%");
        System.out.println("2. PWD - 20%");
        System.out.println("3. Promo - 10%");
        System.out.println("4. Promo - 20%");
        System.out.println("5. No Discount");
        System.out.print("Choose discount: ");

        int choice = scanner.nextInt();

        double discountRate = 0;

        switch (choice) {

            case 1:
                discountRate = 0.20;
                break;

            case 2:
                discountRate = 0.20;
                break;

            case 3:
                discountRate = 0.10;
                break;

            case 4:
                discountRate = 0.20;
                break;

            case 5:
                discountRate = 0;
                break;

            default:
                System.out.println(
                    "Invalid choice. No discount applied."
                );
        }

        return subtotal * discountRate;
    }
}