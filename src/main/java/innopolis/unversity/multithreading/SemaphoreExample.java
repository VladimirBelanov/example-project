package innopolis.unversity.multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Поток " + Thread.currentThread().getName() + " у семафора");
                    semaphore.acquire();
                    System.out.println("Поток " + Thread.currentThread().getName() + " в семафоре");

                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
                System.out.println("Поток " + Thread.currentThread().getName() + " вышел из семафоре");
            }).start();
        }
    }
}
