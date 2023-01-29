package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallbackThenApply {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> calculation = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ...running");
            return " .. returning the result !!!";
        });

        // attach a callback
        CompletableFuture<String> processor = calculation.thenApply(result -> {
            System.out.println(Thread.currentThread().getName() + " ...running");
            return "Thanks for " + result;
        });
        System.out.println(Thread.currentThread().getName() + " ...running");
        // block and wait for the future to return
        System.out.println(processor.get());
    }
}
