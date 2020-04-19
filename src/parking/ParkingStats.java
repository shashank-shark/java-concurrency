package parking;

public class ParkingStats {

    private long numberOfCars;
    private long numberOfMotorCycles;
    private ParkingCash cash;

    private final Object carsController, motorCycleController;
    public ParkingStats(ParkingCash parkingCash) {
        numberOfCars = 0;
        numberOfMotorCycles = 0;

        // initialize the controllers
        carsController = new Object();
        motorCycleController = new Object();

        this.cash = parkingCash;
    }

    /*
     * There are scenarios where:
     * (1) A single method is called by two different threads at the same time.
     * (2) Two different methods are called by two different threads at different times.
     *
     * If one thread is engaged to one method, then other threads can compete for accessing
     * other methods. To achieve this we used the above carsController and motorCycleController.
     */

    public void carComeIn() {
        synchronized (carsController) {
            numberOfCars ++;
        }
    }

    public void carsGoOut() {
        synchronized (carsController) {
            numberOfCars --;
        }
        cash.vehiclePay();
    }

    public void motoComeIn() {
        synchronized (motorCycleController) {
            numberOfMotorCycles ++;
        }
    }

    public void motoGoOut() {
        synchronized (motorCycleController) {
            numberOfMotorCycles --;
        }
        cash.vehiclePay();
    }

    public long getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(long numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public long getNumberOfMotorCycles() {
        return numberOfMotorCycles;
    }

    public void setNumberOfMotorCycles(long numberOfMotorCycles) {
        this.numberOfMotorCycles = numberOfMotorCycles;
    }

    public ParkingCash getCash() {
        return cash;
    }

    public void setCash(ParkingCash cash) {
        this.cash = cash;
    }
}
