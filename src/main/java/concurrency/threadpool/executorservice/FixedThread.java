package concurrency.threadpool.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThread {
    public static void main(String[] args) throws InterruptedException {
        // returns instance of "ThreadPoolExecutor" class
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));

        executorService.shutdown();
    }
}
