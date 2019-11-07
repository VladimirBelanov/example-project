package innopolis.unversity.multithreading;

import java.util.concurrent.TimeUnit;

public class Deadlock {
    private static Object monitorA = new Object();
    private static Object monitorB = new Object();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static void printA() throws InterruptedException {
        synchronized (monitorA) {
            TimeUnit.SECONDS.sleep(1);
            synchronized (monitorB) {

            }
        }
    }

    public static void printB() throws InterruptedException {
        synchronized (monitorB) {
            TimeUnit.SECONDS.sleep(1);
            synchronized (monitorA) {

            }
        }
    }

}
