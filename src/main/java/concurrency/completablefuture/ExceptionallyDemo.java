package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionallyDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    if (name == null)
                        throw new RuntimeException();
                    return "Hello " + name + " !!!";
                }).thenApply(r -> "Hey, " + r)
                .exceptionally(e -> "Exception occurred: " + e);

        System.out.println(completableFuture.get());
    }
}
