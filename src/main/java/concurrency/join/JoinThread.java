package concurrency.join;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                System.out.println(Thread.currentThread().getName()+": "+i);
        });
        thread.start();
        thread.join();
        for (int i = 0; i < 5; i++)
            System.out.println(Thread.currentThread().getName()+": "+i);
    }
}
