package availability;

import food.Food;

/**
 * Utility class for checking food item availability status.
 */
public class FoodAvailability {

    /**
     * Checks if the specified food item is currently available.
     */
    public static boolean isAvailable(Food food) {

        // Returns the availability status flag of the food item
        return food.isAvailable();
    }
}