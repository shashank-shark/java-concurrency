package test1;

import utils.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Minimum Priority : %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority : %s\n", Thread.NORM_PRIORITY);
        System.out.printf("High Priority : %s\n", Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];

        threads = new Thread[10];
        status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {

            // initialize the thread
            threads[i] = new Thread(new Calculator());

            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }

            threads[i].setName("My Thread : " + i);
        }

        try(FileWriter file = new FileWriter("./data1/log.txt"); PrintWriter pw = new PrintWriter(file)) {

            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            // start 10 threads
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }


            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }

                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter writer, Thread thread, Thread.State state) {
        writer.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        writer.printf("Main : Priority: %d\n", thread.getPriority());
        writer.printf("Main : Old State: %s\n", state.toString());
        writer.printf("Main : New State: %s\n", thread.getState());
        writer.printf("Main : ******************************************\n");
    }
}
