package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallbackThenAccept {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> calculation = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ...running");
            return " .. returning the result !!!";
        }).thenAccept(result -> {
            System.out.println(Thread.currentThread().getName() + " ...running");
            System.out.println("Thanks for " + result);
        });

        calculation.get();
    }
}
