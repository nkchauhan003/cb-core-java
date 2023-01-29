package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunBackgroundTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            //a long-running Job
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ... long running job completed !!!");
        });
        System.out.println(Thread.currentThread().getName() + " running..");

        // block and wait for the future to complete
        completableFuture.get();
        System.out.println(Thread.currentThread().getName() + " running..");
    }


}
