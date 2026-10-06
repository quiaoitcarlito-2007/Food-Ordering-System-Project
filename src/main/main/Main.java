package main.main;

import food.Food;
import order.FoodOrder;
import category.FoodCategory;
import availability.FoodAvailability;
import quantity.QuantityManager;
import remove.RemoveItem;
import edit.EditOrder;
import dining.DiningOption;
import table.TableNumber;
import discount.Discount;
import payment.Payment;
import receipt.Receipt;
import ordernumber.OrderNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Food> menu =
            new ArrayList<>();

        // =========================
        // FOOD MENU
        // =========================

        menu.add(new Food(
            1,
            "Burger",
            "Main Course",
            120.00,
            true
        ));

        menu.add(new Food(
            2,
            "Fried Chicken",
            "Main Course",
            150.00,
            true
        ));

        menu.add(new Food(
            3,
            "Spaghetti",
            "Main Course",
            130.00,
            true
        ));

        menu.add(new Food(
            4,
            "French Fries",
            "Snacks",
            80.00,
            true
        ));

        menu.add(new Food(
            5,
            "Chicken Nuggets",
            "Snacks",
            100.00,
            true
        ));

        menu.add(new Food(
            6,
            "Coke",
            "Drinks",
            50.00,
            true
        ));

        menu.add(new Food(
            7,
            "Iced Tea",
            "Drinks",
            60.00,
            true
        ));

        menu.add(new Food(
            8,
            "Ice Cream",
            "Desserts",
            70.00,
            true
        ));

        // =========================
        // CREATE ORDER
        // =========================

        FoodOrder order =
            new FoodOrder();

        boolean checkout = false;

        System.out.println("==================================");

        System.out.println("       FOOD ORDERING SYSTEM");

        System.out.println( "==================================");

        // =========================
        // CONTINUOUS ORDERING
        // =========================

        while (!checkout) {

            System.out.println(
                "\n========== MENU =========="
            );

            System.out.println(
                "1. View All Food"
            );

            System.out.println(
                "2. View Categories"
            );

            System.out.println(
                "3. Add Food"
            );

            System.out.println(
                "4. View Current Order"
            );

            System.out.println(
                "5. Edit Order"
            );

            System.out.println(
                "6. Remove Item"
            );

            System.out.println(
                "7. Checkout"
            );

            System.out.println(
                "=========================="
            );

            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {

                // =========================
                // VIEW ALL FOOD
                // =========================

                case 1:

                    FoodCategory.displayCategory(menu, "All");

                    break;

                // =========================
                // VIEW CATEGORIES
                // =========================

                case 2:

                    FoodCategory.displayCategories();

                    System.out.print("Choose category: ");

                    int categoryChoice =
                        scanner.nextInt();

                    switch (categoryChoice) {

                        case 1:

                            FoodCategory.displayCategory(
                                menu,
                                "Main Course"
                            );

                            break;

                        case 2:

                            FoodCategory.displayCategory(
                                menu,
                                "Snacks"
                            );

                            break;

                        case 3:

                            FoodCategory.displayCategory(
                                menu,
                                "Drinks"
                            );

                            break;

                        case 4:

                            FoodCategory.displayCategory(
                                menu,
                                "Desserts"
                            );

                            break;

                        case 5:

                            FoodCategory.displayCategory(
                                menu,
                                "All"
                            );

                            break;

                        default:

                            System.out.println(
                                "Invalid category."
                            );
                    }

                    break;

                // =========================
                // ADD FOOD
                // =========================

                case 3:

                    FoodCategory.displayCategory(
                        menu,
                        "All"
                    );

                    System.out.print(
                        "Enter food number: "
                    );

                    int foodNumber =
                        scanner.nextInt();

                    if (foodNumber >= 1 &&
                        foodNumber <= menu.size()) {

                        Food selectedFood =
                            menu.get(foodNumber - 1);

                        if (!FoodAvailability.isAvailable(
                                selectedFood)) {

                            System.out.println(
                                "Sorry, this food is unavailable."
                            );

                            break;
                        }

                        int quantity =
                            QuantityManager.getQuantity(
                                scanner
                            );

                        order.addItem(
                            selectedFood,
                            quantity
                        );

                        System.out.println(
                            quantity + " x " +
                            selectedFood.getNAME() +
                            " added to your order."
                        );

                    } else {

                        System.out.println(
                            "Invalid food number."
                        );
                    }

                    break;

                // =========================
                // VIEW CURRENT ORDER
                // =========================

                case 4:

                    order.displayOrder();

                    break;

                // =========================
                // EDIT ORDER
                // =========================

                case 5:

                    EditOrder.edit(
                        order,
                        scanner
                    );

                    break;

                // =========================
                // REMOVE ITEM
                // =========================

                case 6:

                    RemoveItem.remove(
                        order,
                        scanner
                    );

                    break;

                // =========================
                // CHECKOUT
                // =========================

                case 7:

                    if (order.isEmpty()) {

                        System.out.println(
                            "You cannot checkout with an empty order."
                        );

                    } else {

                        checkout = true;
                    }

                    break;

                default:

                    System.out.println(
                        "Invalid choice."
                    );
            }
        }

        // =========================
        // CHECKOUT
        // =========================

        System.out.println(
            "\n========== CHECKOUT =========="
        );

        order.displayOrder();

        // =========================
        // DINING OPTION
        // =========================

        String diningOption =
            DiningOption.choose(scanner);

        int tableNumber = 0;

        if (diningOption.equals("Dine-in")) {

            tableNumber =
                TableNumber.getTableNumber(scanner);
        }

        // =========================
        // DISCOUNT
        // =========================

        double discount =
            Discount.getDiscount(
                scanner,
                order.getSubtotal()
            );

        double total =
            order.getSubtotal() - discount;

        // =========================
        // ORDER NUMBER
        // =========================

        int orderNumber =
            OrderNumber.generate();

        // =========================
        // PAYMENT
        // =========================

        double payment =
            Payment.processPayment(
                scanner,
                total
            );

        // =========================
        // RECEIPT
        // =========================

        Receipt.print(
            order,
            orderNumber,
            diningOption,
            tableNumber,
            discount,
            total,
            payment
        );

        scanner.close();
    }
}