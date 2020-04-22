package prodcons;

public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage eventStorage) {
        this.storage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            storage.set();
        }
    }
}
