package order;

import food.Food;
import java.util.ArrayList;

/**
 * Manages the collection of food items and their corresponding quantities in a customer's order.
 */
public class FoodOrder {

    private ArrayList<Food> foods;
    private ArrayList<Integer> quantities;

    /**
     * Initializes an empty food order with empty lists for foods and quantities.
     */
    public FoodOrder() {

        foods = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    /**
     * Adds a food item to the order or increments its quantity if already present.
     */
    public void addItem(Food food, int quantity) {

        // Check if item is already in the order
        for (int i = 0; i < foods.size(); i++) {

            if (foods.get(i).getID() == food.getID()) {

                // Increment quantity of existing item
                quantities.set(
                    i,
                    quantities.get(i) + quantity
                );

                return;
            }
        }

        // Add new food item and its quantity
        foods.add(food);
        quantities.add(quantity);
    }

    /**
     * Removes an item and its quantity from the order by list index.
     */
    public void removeItem(int index) {

        if (index >= 0 && index < foods.size()) {

            foods.remove(index);
            quantities.remove(index);
        }
    }

    /**
     * Updates the quantity of a specific order item or removes it if quantity is zero or negative.
     */
    public void editQuantity(int index, int quantity) {

        if (index >= 0 && index < quantities.size()) {

            if (quantity <= 0) {
                removeItem(index);
            } else {
                quantities.set(index, quantity);
            }
        }
    }

    // Gets the list of foods in the order
    public ArrayList<Food> getFoods() {
        return foods;
    }

    // Gets the list of quantities for each food in the order
    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    /**
     * Calculates and returns the current subtotal of all items in the order.
     */
    public double getSubtotal() {

        double total = 0;

        for (int i = 0; i < foods.size(); i++) {

            total += foods.get(i).getPRICE()
                    * quantities.get(i);
        }

        return total;
    }

    // Checks whether the order contains any items
    public boolean isEmpty() {
        return foods.isEmpty();
    }

    /**
     * Prints an itemized view of the current order along with the calculated subtotal.
     */
    public void displayOrder() {

        if (foods.isEmpty()) {

            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("\n========== CURRENT ORDER ==========");

        // Display individual items with quantities and extended prices
        for (int i = 0; i < foods.size(); i++) {

            Food food = foods.get(i);

            int quantity = quantities.get(i);

            double total =
                food.getPRICE() * quantity;

            System.out.println(
                (i + 1) + ". " +
                food.getNAME() +
                " x" + quantity +
                " - $" + total
            );
        }

        System.out.println("-----------------------------------");

        System.out.println(
            "Subtotal: $" + getSubtotal()
        );

        System.out.println(
            "==================================="
        );
    }
}