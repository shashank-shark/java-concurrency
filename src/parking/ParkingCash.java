package parking;

public class ParkingCash {

    private static final int cost = 2;
    private long cash;

    public ParkingCash() {
        // initally cash will be zero
        cash = 0;
    }

    // we have to make this method synchronized as multiple threads will try to update
    // the cost
    public synchronized void vehiclePay() {
        cash = cash + cost;
    }

    // this function will write the cash attribute value and initialize
    // the cost variable to zero
    public void close() {
        System.out.printf("Closing accounting ");
        long totalAmount;

        // multiple threads will try to update the values, so we add synchronized block
        synchronized (this) {
            totalAmount = cash;
            cash = 0;
        }

        System.out.printf("The total amount is : %d", totalAmount);
    }
}
