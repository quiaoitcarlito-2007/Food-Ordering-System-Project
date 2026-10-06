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

/**
 * Main entry point for the Food Ordering System application[cite: 3].
 * Handles menu initialization, interactive customer workflow, and checkout operations[cite: 3].
 */
public class Main {

    /**
     * Executes the food ordering application lifecycle[cite: 3].
     */
    public static void main(String[] args) {

        // Initialize Scanner for reading console inputs[cite: 3]
        Scanner scanner = new Scanner(System.in);

        // List to store available menu items[cite: 3]
        ArrayList<Food> menu =
            new ArrayList<>();

        // =========================
        // FOOD MENU
        // =========================

        // Initialize menu items with ID, Name, Category, Price, and Availability[cite: 3]
        menu.add(new Food(
            1,
            "Burger",
            "Main Course",
            120.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            2,
            "Fried Chicken",
            "Main Course",
            150.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            3,
            "Spaghetti",
            "Main Course",
            130.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            4,
            "French Fries",
            "Snacks",
            80.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            5,
            "Chicken Nuggets",
            "Snacks",
            100.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            6,
            "Coke",
            "Drinks",
            50.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            7,
            "Iced Tea",
            "Drinks",
            60.00,
            true
        )); //[cite: 3]

        menu.add(new Food(
            8,
            "Ice Cream",
            "Desserts",
            70.00,
            true
        )); //[cite: 3]

        // =========================
        // CREATE ORDER
        // =========================

        // Instance tracking current items added by customer[cite: 3]
        FoodOrder order =
            new FoodOrder();

        // Control flag for main ordering loop[cite: 3]
        boolean checkout = false;

        System.out.println("=================================="); //[cite: 3]
        System.out.println("       FOOD ORDERING SYSTEM"); //[cite: 3]
        System.out.println("=================================="); //[cite: 3]

        // =========================
        // CONTINUOUS ORDERING
        // =========================

        // Main navigation loop; runs until customer proceeds to checkout[cite: 3]
        while (!checkout) {

            System.out.println(
                "\n========== MENU =========="
            ); //[cite: 3]

            System.out.println(
                "1. View All Food"
            ); //[cite: 3]

            System.out.println(
                "2. View Categories"
            ); //[cite: 3]

            System.out.println(
                "3. Add Food"
            ); //[cite: 3]

            System.out.println(
                "4. View Current Order"
            ); //[cite: 3]

            System.out.println(
                "5. Edit Order"
            ); //[cite: 3]

            System.out.println(
                "6. Remove Item"
            ); //[cite: 3]

            System.out.println(
                "7. Checkout"
            ); //[cite: 3]

            System.out.println(
                "=========================="
            ); //[cite: 3]

            System.out.print("Choose: "); //[cite: 3]

            // Read customer menu choice[cite: 3]
            int choice = scanner.nextInt();

            switch (choice) {

                // =========================
                // VIEW ALL FOOD
                // =========================

                case 1:

                    // Display all items in menu[cite: 3]
                    FoodCategory.displayCategory(menu, "All");

                    break;

                // =========================
                // VIEW CATEGORIES
                // =========================

                case 2:

                    // Display category options and query sub-selection[cite: 3]
                    FoodCategory.displayCategories();

                    System.out.print("Choose category: "); //[cite: 3]

                    int categoryChoice =
                        scanner.nextInt();

                    switch (categoryChoice) {

                        case 1:

                            FoodCategory.displayCategory(
                                menu,
                                "Main Course"
                            ); //[cite: 3]

                            break;

                        case 2:

                            FoodCategory.displayCategory(
                                menu,
                                "Snacks"
                            ); //[cite: 3]

                            break;

                        case 3:

                            FoodCategory.displayCategory(
                                menu,
                                "Drinks"
                            ); //[cite: 3]

                            break;

                        case 4:

                            FoodCategory.displayCategory(
                                menu,
                                "Desserts"
                            ); //[cite: 3]

                            break;

                        case 5:

                            FoodCategory.displayCategory(
                                menu,
                                "All"
                            ); //[cite: 3]

                            break;

                        default:

                            System.out.println(
                                "Invalid category."
                            ); //[cite: 3]
                    }

                    break;

                // =========================
                // ADD FOOD
                // =========================

                case 3:

                    // Prompt food selection by index and add desired quantity to order[cite: 3]
                    FoodCategory.displayCategory(
                        menu,
                        "All"
                    ); //[cite: 3]

                    System.out.print(
                        "Enter food number: "
                    ); //[cite: 3]

                    int foodNumber =
                        scanner.nextInt();

                    // Check if selected number corresponds to a valid menu item index[cite: 3]
                    if (foodNumber >= 1 &&
                        foodNumber <= menu.size()) {

                        Food selectedFood =
                            menu.get(foodNumber - 1);

                        // Prevent adding item if currently out of stock/unavailable[cite: 3]
                        if (!FoodAvailability.isAvailable(
                                selectedFood)) {

                            System.out.println(
                                "Sorry, this food is unavailable."
                            ); //[cite: 3]

                            break;
                        }

                        // Retrieve valid quantity input from user[cite: 3]
                        int quantity =
                            QuantityManager.getQuantity(
                                scanner
                            );

                        // Add selected food item and quantity to current order[cite: 3]
                        order.addItem(
                            selectedFood,
                            quantity
                        );

                        System.out.println(
                            quantity + " x " +
                            selectedFood.getNAME() +
                            " added to your order."
                        ); //[cite: 3]

                    } else {

                        System.out.println(
                            "Invalid food number."
                        ); //[cite: 3]
                    }

                    break;

                // =========================
                // VIEW CURRENT ORDER
                // =========================

                case 4:

                    // Display itemized list of current order contents[cite: 3]
                    order.displayOrder();

                    break;

                // =========================
                // EDIT ORDER
                // =========================

                case 5:

                    // Modify item quantities within current order[cite: 3]
                    EditOrder.edit(
                        order,
                        scanner
                    );

                    break;

                // =========================
                // REMOVE ITEM
                // =========================

                case 6:

                    // Remove selected item completely from current order[cite: 3]
                    RemoveItem.remove(
                        order,
                        scanner
                    );

                    break;

                // =========================
                // CHECKOUT
                // =========================

                case 7:

                    // Ensure order contains items before exiting loop to proceed[cite: 3]
                    if (order.isEmpty()) {

                        System.out.println(
                            "You cannot checkout with an empty order."
                        ); //[cite: 3]

                    } else {

                        checkout = true; //[cite: 3]
                    }

                    break;

                default:

                    System.out.println(
                        "Invalid choice."
                    ); //[cite: 3]
            }
        }

        // =========================
        // CHECKOUT
        // =========================

        System.out.println(
            "\n========== CHECKOUT =========="
        ); //[cite: 3]

        // Review order details one final time[cite: 3]
        order.displayOrder();

        // =========================
        // DINING OPTION
        // =========================

        // Get option (e.g., Dine-in vs Takeout)[cite: 3]
        String diningOption =
            DiningOption.choose(scanner);

        int tableNumber = 0;

        // Prompt table selection if dining in[cite: 3]
        if (diningOption.equals("Dine-in")) {

            tableNumber =
                TableNumber.getTableNumber(scanner);
        }

        // =========================
        // DISCOUNT
        // =========================

        // Calculate monetary discount based on subtotal[cite: 3]
        double discount =
            Discount.getDiscount(
                scanner,
                order.getSubtotal()
            );

        // Deduct discount from order subtotal[cite: 3]
        double total =
            order.getSubtotal() - discount;

        // =========================
        // ORDER NUMBER
        // =========================

        // Generate tracking identifier for this order[cite: 3]
        int orderNumber =
            OrderNumber.generate();

        // =========================
        // PAYMENT
        // =========================

        // Process payment and calculate change[cite: 3]
        double payment =
            Payment.processPayment(
                scanner,
                total
            );

        // =========================
        // RECEIPT
        // =========================

        // Print customer transaction receipt[cite: 3]
        Receipt.print(
            order,
            orderNumber,
            diningOption,
            tableNumber,
            discount,
            total,
            payment
        );

        // Close scanner to release system resources[cite: 3]
        scanner.close();
    }
}