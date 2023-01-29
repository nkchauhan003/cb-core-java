package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionWhenComplete {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String username = null;
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (username == null)
                throw new RuntimeException();
            return "Username is: " + username;
        }).whenComplete((r, e) -> {
            if (r == null)
                System.out.println("Exception occurred: " + e);
            else
                System.out.println(r);
        });

        try {
            completableFuture.get();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

}
