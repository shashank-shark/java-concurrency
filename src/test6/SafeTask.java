package test6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {

    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread %s : %s\n", Thread.currentThread().getId(), startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.printf("Thread finished %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }
}
