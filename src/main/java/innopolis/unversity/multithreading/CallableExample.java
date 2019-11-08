package innopolis.unversity.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 10;
        });

        new Thread(task).start();

        System.out.println(task.get());
    }
}
