package payment;

import java.util.Scanner;

public class Payment {

    public static double processPayment(
            Scanner scanner,
            double total) {

        double payment;

        while (true) {

            System.out.println(
                "\nTotal Amount: $" + total
            );

            System.out.print(
                "Enter payment: $"
            );

            payment = scanner.nextDouble();

            if (payment >= total) {

                return payment;
            }

            System.out.println(
                "Insufficient payment."
            );
        }
    }
}