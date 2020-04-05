package test5;

import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {

    private Deque<Event> deque;
    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (deque.size() == 0) {
            return;
        }

        delete = false;
        do {
            Event event = deque.getLast();
            difference = date.getTime() - event.getDate().getTime();

            if (difference > 10000) {
                System.out.printf("Cleaner: %s\n", event.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > 10000);

        if (delete) {
            System.out.printf("Size of the queue : %d\n", deque.size());
        }
    }
}
