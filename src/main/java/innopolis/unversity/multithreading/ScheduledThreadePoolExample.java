package innopolis.unversity.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadePoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        service.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 5, TimeUnit.SECONDS);

        service.scheduleWithFixedDelay(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 5, TimeUnit.SECONDS);
    }
}
