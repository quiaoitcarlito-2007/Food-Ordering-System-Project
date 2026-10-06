package food;

public class Food {
    
    private int id;
    private String name;
    private double price;
    private String category;
    private boolean available;

    public Food(int id, String name, String category, double price, boolean available)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    public int getID() 
    {
        return id;
    }

    public String getNAME() 
    {
        return name;
    }

    public String getCATEGORY() 
    {
        return category;
    }

    public double getPRICE() 
    {
        return price;
    }

     public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void display() 
    {
        System.out.printf("%d. %-20s $%.2f %s%n", id, name, price, available ? "" : "(UNAVAILABLE)");
    }




}
   