package prodcons;

public class Main {

    public static void main (String[] args) {
        EventStorage eventStorage = new EventStorage();

        Producer producer = new Producer(eventStorage);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(eventStorage);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
