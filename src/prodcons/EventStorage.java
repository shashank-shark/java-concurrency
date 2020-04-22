package prodcons;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {

    private int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<Date>();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException interuptedException) {
                interuptedException.printStackTrace();
            }
        }

        storage.offer(new Date());
        System.out.printf("Set : %d", storage.size());

        // so if the queue size is full, then we call the notify method
        notify();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        String element = storage.poll().toString();
        System.out.printf("Get: %d: %s\n", storage.size(), element);
        notify();
    }
}
