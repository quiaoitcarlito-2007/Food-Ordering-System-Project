package category;

import food.Food;
import java.util.ArrayList;

/**
 * Provides utility methods to display available food categories 
 * and filter food items based on selected categories.
 */
public class FoodCategory {

    /**
     * Displays the main menu options for available food categories to the user.
     */
    public static void displayCategories() {
        System.out.println("\n========== CATEGORIES ==========");
        System.out.println("1. Main Course");
        System.out.println("2. Snacks");
        System.out.println("3. Drinks");
        System.out.println("4. Desserts");
        System.out.println("5. All Foods");
        System.out.println("================================");
    }

    /**
     * Filters and displays food items from the menu based on the specified category.
     */
    public static void displayCategory(ArrayList<Food> menu, String category) {

        // Print header with category name capitalized
        System.out.println(
            "\n========== " +
            category.toUpperCase() +
            " =========="
        );

        // Iterate through each food item in the menu list
        for (Food food : menu) {

            // Check if the user requested all foods or if the food's category matches the target category
            if (category.equalsIgnoreCase("All")
                    || food.getCATEGORY().equalsIgnoreCase(category)) {

                // Display individual food details
                food.display();
            }
        }

        // Print footer divider
        System.out.println(
            "================================"
        );
    }
}