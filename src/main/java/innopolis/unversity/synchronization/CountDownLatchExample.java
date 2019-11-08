package innopolis.unversity.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(5);
        for (int i = 0; i < 10; i++) {

            System.out.println("Start");
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500 + (int) (Math.random() * 1000 ));
                    System.out.println("Ready");
                    cb.await();
                    System.out.println("Finish");
                    cb.reset();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
