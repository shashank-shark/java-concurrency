package readwritelock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {

    private double price1;
    private double price2;

    private final ReadWriteLock readWriteLock;

    public PriceInfo() {
        this.price1 = 1.0;
        this.price2 = 2.0;
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        readWriteLock.readLock().lock();
        double value = price1;
        readWriteLock.readLock().unlock();
        return value;
    }

    public void setPrices(double price1, double price2) {
        readWriteLock.writeLock().lock();
        System.out.printf("%s: Prices Info: Write Lock Acquired.\n", new Date());
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch(InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        this.price1 = price1;
        this.price2 = price2;
        System.out.printf("%s: Prices Info: Write Lock Released.\n", new Date());
        readWriteLock.writeLock().unlock();
    }

    public double getPrice2() {
        readWriteLock.readLock().lock();
        double value = price2;
        readWriteLock.readLock().unlock();
        return value;
    }
}
