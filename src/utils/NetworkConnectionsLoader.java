package utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Starting Network Connection Loader : %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.printf("Finished loading of network resources : %s\n", new Date());
    }
}
