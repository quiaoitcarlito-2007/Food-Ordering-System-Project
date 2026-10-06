package order;

import food.Food;
import java.util.ArrayList;

public class FoodOrder {

    private ArrayList<Food> foods;
    private ArrayList<Integer> quantities;

    public FoodOrder() {

        foods = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(Food food, int quantity) {

        for (int i = 0; i < foods.size(); i++) {

            if (foods.get(i).getID() == food.getID()) {

                quantities.set(
                    i,
                    quantities.get(i) + quantity
                );

                return;
            }
        }

        foods.add(food);
        quantities.add(quantity);
    }

    public void removeItem(int index) {

        if (index >= 0 && index < foods.size()) {

            foods.remove(index);
            quantities.remove(index);
        }
    }

    public void editQuantity(int index, int quantity) {

        if (index >= 0 && index < quantities.size()) {

            if (quantity <= 0) {
                removeItem(index);
            } else {
                quantities.set(index, quantity);
            }
        }
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public double getSubtotal() {

        double total = 0;

        for (int i = 0; i < foods.size(); i++) {

            total += foods.get(i).getPRICE()
                    * quantities.get(i);
        }

        return total;
    }

    public boolean isEmpty() {
        return foods.isEmpty();
    }

    public void displayOrder() {

        if (foods.isEmpty()) {

            System.out.println("Your order is empty.");
            return;
        }

        System.out.println("\n========== CURRENT ORDER ==========");

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