package ordernumber;

/**
 * Generates unique, sequential order numbers for customer transactions.
 */
public class OrderNumber {

    // Tracks the starting sequence number for order generation
    private static int number = 1000;

    /**
     * Increments and returns the next available order number in the sequence.
     */
    public static int generate() {

        // Increment current sequence counter
        number++;

        // Return updated order number
        return number;
    }
}