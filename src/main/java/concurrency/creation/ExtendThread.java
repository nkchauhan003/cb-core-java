package concurrency.creation;

class ThreadB extends Thread {
    @Override
    public void run() {
        System.out.println("Thread started: " + this.getName());
        System.out.println("Thread started: " + currentThread().getName());
    }
}

public class ExtendThread {
    public static void main(String[] args) {
        Thread thread = new ThreadB();
        thread.start();
    }
}
