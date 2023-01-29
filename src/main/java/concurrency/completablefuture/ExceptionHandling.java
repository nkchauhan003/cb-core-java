package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandling {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String username = null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    if (username == null)
                        throw new RuntimeException();
                    return "Username is: " + username;
                }).handle((r, e) -> r == null ? "Invalid Username: " + e.getMessage() : r)
                .thenApply(r -> r + " ...");

        System.out.println(completableFuture.get());
    }
}
