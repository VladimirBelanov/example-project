package innopolis.unversity.synchronization;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        method();
                        lock.unlock();
                    } else {
                        throw new RuntimeException("Timeout");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    public static void method() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("I'm done " + Thread.currentThread().getName());
    }
}
