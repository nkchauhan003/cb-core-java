package concurrency.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AreaCalculator {
    private ExecutorService executor
            = Executors.newFixedThreadPool(3);

    public Future<Integer> calculate(int length, int width) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return length * width;
        });
    }

    public void shutdown() {
        this.executor.shutdown();
    }
}
