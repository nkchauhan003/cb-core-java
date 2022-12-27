package concurrency.creation;

class ThreadA implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName());
    }
}

public class ImplementRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadA());
        thread.start();
    }
}
