package concurrency.creation;

public class ImplementRunnable {
    public static void main(String[] args) {

        // runnable instance
        Runnable runnable = new RunnableImpl();

        // thread instance
        Thread thread = new Thread(runnable);

        // starting a thread
        thread.start();
    }

    private static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread started: " + Thread.currentThread().getName());
        }
    }
}
