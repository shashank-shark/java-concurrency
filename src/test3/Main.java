package test3;

import utils.FileSearch;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        FileSearch fileSearch = new FileSearch("/home/shashank/coding", "trueClient");
        Thread thread = new Thread(fileSearch);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        thread.interrupt();
    }
}
