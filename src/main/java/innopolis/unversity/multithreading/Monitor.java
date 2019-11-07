package innopolis.unversity.multithreading;

import java.util.concurrent.TimeUnit;

public class Monitor {
    private static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        final Monitor main = new Monitor();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    main.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    main.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void method() throws InterruptedException {
        System.out.println("M1");
        TimeUnit.SECONDS.sleep(1);
        synchronized (monitor) {
            System.out.println("syn M1");
        }

    }

    public void method1() throws InterruptedException {
        synchronized (monitor) {
            System.out.println("syn M2");
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("M2");
    }
}
