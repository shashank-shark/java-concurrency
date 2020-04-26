package filemock;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(buffer.hasPendingLines()) {
            String line = buffer.get();
        }
    }

    public void processLine(String line) {
        try {
            TimeUnit.MILLISECONDS.sleep(4);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
