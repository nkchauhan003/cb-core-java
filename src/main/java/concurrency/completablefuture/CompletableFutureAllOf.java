package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureAllOf {

    static ExecutorService threadPool = Executors.newFixedThreadPool(5);

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

    public static CompletableFuture<String> getUserProfile(String user) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return user + "'s Profile";
        }, threadPool);
    }

    public static CompletableFuture<String> getUserTransactions(String user) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return user + "'s Transactions";
        }, threadPool);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String user = "User";

        CompletableFuture<String> account = getUserAccount(user);
        CompletableFuture<String> profile = getUserProfile(user);
        CompletableFuture<String> transactions = getUserTransactions(user);

        CompletableFuture<Void> userDetailsFuture = CompletableFuture.allOf(account,
                profile, transactions);

        String userDetails = Stream.of(account, profile, transactions)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(userDetails);
        threadPool.shutdown();
    }
}
