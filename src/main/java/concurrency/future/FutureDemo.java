package concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        AreaCalculator areaCalculator = new AreaCalculator();
        Future<Integer> areaFutureA = areaCalculator.calculate(10, 20);
        Future<Integer> areaFutureB = areaCalculator.calculate(15, 25);

        while (!areaFutureA.isDone() || !areaFutureB.isDone()) {
            System.out.println(
                    String.format(
                            "areaFutureA calculation is %s and areaFutureB calculation is %s",
                            areaFutureA.isDone() ? "done !!!" : "running ...",
                            areaFutureB.isDone() ? "done !!!" : "running ..."
                    )
            );
            Thread.sleep(300);
        }

        Integer areaA = areaFutureA.get(1500, TimeUnit.MILLISECONDS);
        Integer areaB = areaFutureB.get(1500, TimeUnit.MILLISECONDS);
        System.out.println("AreaA: " + areaA + ", AreaB: " + areaB);
        System.out.println("Calculation is complete !!!");
        areaCalculator.shutdown();
    }
}
