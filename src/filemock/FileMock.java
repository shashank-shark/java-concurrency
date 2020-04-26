package filemock;

public class FileMock {

    private String[] content;
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < size; j++) {
                int randomCharacter = (int) (Math.random() * 255);
                buffer.append((char) randomCharacter);
            }
            content[i] = buffer.toString();
        }
        //reset the index.
        index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.printf("Mock: %d:", (content.length - index));
            return content[index++];
        }
        return null;
    }
}
