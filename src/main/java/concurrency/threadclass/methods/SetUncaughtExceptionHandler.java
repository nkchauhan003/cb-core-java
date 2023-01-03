package concurrency.threadclass.methods;

public class SetUncaughtExceptionHandler {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Current thread: " + Thread.currentThread().getName());
                throw new RuntimeException();
            }
        });
        thread.setName("Th Thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical exception happened in thread: " + Thread.currentThread().getName());
            }
        });
        thread.start();
    }
}
