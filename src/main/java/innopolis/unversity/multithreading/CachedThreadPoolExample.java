package innopolis.unversity.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService cachedTP = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            cachedTP.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        cachedTP.shutdown();
    }
}
