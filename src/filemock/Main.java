package filemock;

public class Main {

    public static void main(String[] args) {

        FileMock fileMock = new FileMock(100,10);

        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(fileMock, buffer);
        Thread producerThread = new Thread(producer, "Producer Thread");

        Consumer[] consumers = new Consumer[3];
        Thread[] consumerThreads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            consumerThreads[i] = new Thread(consumers[i], "Consumer " + i);
        }

        producerThread.start();
        for (int i = 0; i < 3; i++) {
            consumerThreads[i].start();
        }
    }
}
