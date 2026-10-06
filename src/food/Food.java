package food;

/**
 * Represents an individual food item with its metadata and availability status.
 */
public class Food {
    
    private int id;
    private String name;
    private double price;
    private String category;
    private boolean available;

    /**
     * Constructs a new Food object with specified attributes.
     */
    public Food(int id, String name, String category, double price, boolean available)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    // Gets the food item ID
    public int getID() 
    {
        return id;
    }

    // Gets the name of the food item
    public String getNAME() 
    {
        return name;
    }

    // Gets the category of the food item
    public String getCATEGORY() 
    {
        return category;
    }

    // Gets the price of the food item
    public double getPRICE() 
    {
        return price;
    }

    // Checks whether the food item is available for ordering
    public boolean isAvailable() {
        return available;
    }

    // Updates the availability status of the food item
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Prints formatted details of the food item, appending (UNAVAILABLE) if inactive.
     */
    public void display() 
    {
        System.out.printf("%d. %-20s $%.2f %s%n", id, name, price, available ? "" : "(UNAVAILABLE)");
    }
}