package readwritelock;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Writer implements Runnable {

    private final PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s: Writer: Attempt to modify the prices.\n", new Date());
            priceInfo.setPrices(Math.random()*10, Math.random()*8);
            System.out.printf("%s: Writer: Prices have been modified.\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
