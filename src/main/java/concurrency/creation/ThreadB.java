package concurrency.creation;

public class ThreadB extends Thread {
    @Override
    public void run() {
        System.out.println("Thread started: " + Thread.currentThread().getName());
    }
}

class DriverB {
    public static void main(String[] args) {
        Thread thread = new ThreadB();
        thread.start();
    }
}
