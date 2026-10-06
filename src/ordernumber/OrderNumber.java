package ordernumber;

public class OrderNumber {

    private static int number = 1000;

    public static int generate() {

        number++;

        return number;
    }
}