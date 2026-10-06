package table;

import java.util.Scanner;

public class TableNumber {

    public static int getTableNumber(Scanner scanner) {

        int table;

        while (true) {

            System.out.print("Enter table number: ");

            table = scanner.nextInt();

            if (table > 0) {
                return table;
            }

            System.out.println("Invalid table number.");
        }
    }
}