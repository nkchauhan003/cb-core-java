package concurrency.exercise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    queue.put("Something !!!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(
                            "Consumed: " + queue.take() + ", RemainingCapacity: " + queue.remainingCapacity());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
