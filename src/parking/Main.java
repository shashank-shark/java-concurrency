package parking;

public class Main {

    public static void main(String[] args) {

        ParkingCash parkingCash = new ParkingCash();
        ParkingStats parkingStats = new ParkingStats(parkingCash);

        System.out.printf("Parking Simulator\n");

        // get the number of processors
        int numberOfSensors = 2 * Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[numberOfSensors];
        // initialize a new thread
        for (int i = 0; i < numberOfSensors; i++) {
            Sensor sensor = new Sensor(parkingStats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        // now we wait for the finalization of the threads using join() method
        for (int i = 0; i < numberOfSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        System.out.printf("Number of cars : %d\n", parkingStats.getNumberOfCars());
        System.out.printf("Number of motorcycles : %d\n", parkingStats.getNumberOfMotorCycles());
        parkingCash.close();
    }
}
