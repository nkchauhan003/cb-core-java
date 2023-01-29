package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackThenRunAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> calculation = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " ...running");
            System.out.println(" .. I am done !!!");
        }).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " ...running");
            System.out.println(" ..thanks, I am done too !!!");
        }, threadPool);

        calculation.get();
    }
}
