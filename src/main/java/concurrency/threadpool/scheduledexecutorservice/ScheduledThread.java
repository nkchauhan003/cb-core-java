package concurrency.threadpool.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThread {
    public static void main(String[] args) {

        // returns an object of 'ScheduledThreadPoolExecutor'
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        // run a task once after a specified delay
        executor.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
        }, 1000, TimeUnit.MILLISECONDS);


        // repeatedly runs the given task
        executor.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + " AtFixedRate running...");
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        // repeatedly runs the given task
        // delay is measured from the end of the previous task
        executor.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + " WithFixedDelay running...");
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }
}
