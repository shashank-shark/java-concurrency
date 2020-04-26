package filemock;

public class Producer implements Runnable {

    private final FileMock fileMock;
    private final Buffer buffer;

    public Producer(FileMock fileMock, Buffer buffer) {
        this.buffer = buffer;
        this.fileMock = fileMock;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (fileMock.hasMoreLines()) {
            String line = fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
