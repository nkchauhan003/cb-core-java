package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureCompose {

    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static CompletableFuture<String> getUser(int userId) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "User-" + userId;
        }, threadPool);
    }

    public static CompletableFuture<String> getUserAccount(String user) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return user + "'s Account";
        }, threadPool);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int userId = 101;
        CompletableFuture<String> userDetails = getUser(userId).thenComposeAsync(user -> getUserAccount(user),
                threadPool);
        System.out.println(userDetails.get());

        threadPool.shutdown();
    }
}
