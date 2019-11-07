package innopolis.unversity.multithreading;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableExample());
        thread.start();

        Thread thread1 = new ThreadExample();
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

    public static class ThreadExample extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static class RunnableExample implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
