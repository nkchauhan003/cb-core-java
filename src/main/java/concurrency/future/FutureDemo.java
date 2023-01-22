package concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> future = squareCalculator.calculate(10);

        while (!future.isDone())
            System.out.println("Calculating...");

        Integer result = future.get(2000, TimeUnit.MILLISECONDS);
        System.out.println("Result: " + result);

        System.out.println("Calculation is complete !!!");
        squareCalculator.shutdown();

    }
}
