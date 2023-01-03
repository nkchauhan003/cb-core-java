package concurrency.threadclass.methods;

public class CurrentThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Current thread name: " + Thread.currentThread().getName());
                System.out.println("Current thread id: " + Thread.currentThread().getId());
                System.out.println("Current thread priority: " + Thread.currentThread().getPriority());
            }
        }, "CB-Thread");

        thread.start();

        System.out.println("Current th name: " + Thread.currentThread().getName());
        System.out.println("Current th id: " + Thread.currentThread().getId());
        System.out.println("Current th priority: " + Thread.currentThread().getPriority());
    }
}
