package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureAnyOf {

    static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static CompletableFuture<String> searchA(String term) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "I got it in a..." + term;
        }, threadPool);
    }

    public static CompletableFuture<String> searchB(String term) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "I got it in b..." + term;
        }, threadPool);
    }

    public static CompletableFuture<String> searchC(String term) {

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "..running");
            // long calculation
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "I got it in c..." + term;
        }, threadPool);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String term = "a good developer";

        CompletableFuture<String> searchA = searchA(term);
        CompletableFuture<String> searchB = searchB(term);
        CompletableFuture<String> searchC = searchC(term);

        CompletableFuture<Object> goodDeveloper = CompletableFuture.anyOf(searchA,
                searchB, searchC);

        System.out.println(goodDeveloper.get());
        threadPool.shutdown();
    }
}
