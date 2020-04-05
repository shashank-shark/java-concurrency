package test2;

import utils.PrimeGenerator;

public class Main {
    public static void main(String[] args) {
        Thread primeNumberGenerationTask = new PrimeGenerator();
        primeNumberGenerationTask.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        primeNumberGenerationTask.interrupt();

        System.out.printf("Main : Status of the Thread : %s\n", primeNumberGenerationTask.getState());
        System.out.printf("Main : isInterrupted() : %s\n", primeNumberGenerationTask.isInterrupted());
        System.out.printf("Main : isAlive() : %s\n", primeNumberGenerationTask.isAlive());
    }
}
