package parking;

import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable {

    private ParkingStats parkingStats;

    public Sensor(ParkingStats parkingStats) {
        this.parkingStats = parkingStats;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            parkingStats.carComeIn();
            parkingStats.carComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            parkingStats.motoComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            parkingStats.motoGoOut();
            parkingStats.carsGoOut();
            parkingStats.carsGoOut();
        }
    }
}
