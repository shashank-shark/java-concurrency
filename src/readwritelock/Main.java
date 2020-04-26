package readwritelock;

public class Main {

    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        // lets create five readers
        Reader[] readers = new Reader[5];
        Thread[] threadsReader = new Thread[5];

        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(priceInfo);
            threadsReader[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(priceInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }

        threadWriter.start();
    }
}
