package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallbackThenRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> calculation = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ...running");
            System.out.println(" .. I am done !!!");
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName() + " ...running");
            System.out.println(" ..thanks, I am done too !!!");
        });

        calculation.get();
    }
}
