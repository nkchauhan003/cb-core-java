package concurrency.threadpool.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {
    public static void main(String[] args) {
        // returns instance of "ThreadPoolExecutor" class
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " running !!!"));
    }
}
