package utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning Data Source Loading ... : %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.printf("Data Source Loading finished : %s\n", new Date());
    }
}
