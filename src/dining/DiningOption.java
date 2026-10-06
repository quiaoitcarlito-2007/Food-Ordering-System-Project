package dining;

import java.util.Scanner;

public class DiningOption {

    public static String choose(
            Scanner scanner) {

        while (true) {

            System.out.println(
                "\n========== ORDER TYPE =========="
            );

            System.out.println("1. Dine-in");
            System.out.println("2. Takeout");

            System.out.print("Choose: ");

            int choice = scanner.nextInt();

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