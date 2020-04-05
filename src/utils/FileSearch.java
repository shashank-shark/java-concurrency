package utils;

import java.io.File;

public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    @Override
    public void run() {

        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {

        File[] list = file.listFiles();
        if (list != null) {
            for (File value : list) {
                if (value.isDirectory()) {
                    directoryProcess(value);
                } else {
                    fileProcess(value);
                }
            }
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsoluteFile());
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }
}
