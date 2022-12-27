package concurrency.creation;

public class ThreadA implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName());
    }
}

class DriverA {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadA());
        thread.start();
    }
}
