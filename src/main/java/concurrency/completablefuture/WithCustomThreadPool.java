package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithCustomThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Runnable runnable = () -> {
            //a long-running Job
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ... long running job completed !!!");
        };

        // passing a runnable and user-defined thread-pool
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, threadPool);
        System.out.println(Thread.currentThread().getName() + " running..");

        // block and wait for the future to complete
        completableFuture.get();
        System.out.println(Thread.currentThread().getName() + " running..");
    }
}
