package lockinterface;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private final Lock queueLock;

    public PrintQueue(boolean fairMode) {
        queueLock = new ReentrantLock(fairMode);
    }

    public void printJob(Object document) {

        /* first get the lock on the queue */
        queueLock.lock();

        /* now do the printing process - fairMode */
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s : PrintQueue: Printing a Job during: %d seconds\n",Thread.currentThread().getName() ,(duration/1000));
            Thread.sleep(duration);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        /* again do the printing process, this time in non-fair mode */
        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("%s : PrintQueue: Printing a Job during: %d seconds\n",Thread.currentThread().getName() ,(duration/1000));
            Thread.sleep(duration);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            queueLock.unlock();
        }

    }
}
