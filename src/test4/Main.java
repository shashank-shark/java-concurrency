package test4;

import utils.DataSourceLoader;
import utils.NetworkConnectionsLoader;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        DataSourceLoader dataSourceLoader = new DataSourceLoader();
        NetworkConnectionsLoader connectionsLoader = new NetworkConnectionsLoader();

        Thread dataLoaderThread = new Thread(dataSourceLoader);
        Thread networkLoader = new Thread(connectionsLoader);

        dataLoaderThread.start();
        networkLoader.start();

        try {
            dataLoaderThread.join();
            networkLoader.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.out.printf("Configuration has been loaded : %s\n", new Date());
    }
}
