package category;

import food.Food;
import java.util.ArrayList;

public class FoodCategory {

    public static void displayCategories() {

        System.out.println("\n========== CATEGORIES ==========");
        System.out.println("1. Main Course");
        System.out.println("2. Snacks");
        System.out.println("3. Drinks");
        System.out.println("4. Desserts");
        System.out.println("5. All Foods");
        System.out.println("================================");
    }

    public static void displayCategory(
            ArrayList<Food> menu,
            String category) {

        System.out.println(
            "\n========== " +
            category.toUpperCase() +
            " =========="
        );

        for (Food food : menu) {

            if (category.equalsIgnoreCase("All")
                    || food.getCATEGORY()
                          .equalsIgnoreCase(category)) {

                food.display();
            }
        }

        System.out.println(
            "================================"
        );
    }
}