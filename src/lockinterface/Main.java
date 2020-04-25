package lockinterface;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Running example with fair-mode = false\n");
        testPrintQueue(false);
        System.out.printf("Running example with fair-mode = true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(boolean fairMode) {

        PrintQueue printQueue = new PrintQueue(fairMode);

        // create 10 objects and 10 threads to run
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        // wait for the finalization of 10 threads
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
