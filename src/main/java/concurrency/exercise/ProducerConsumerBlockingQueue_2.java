package concurrency.exercise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue_2 {
    public static void main(String[] args) {
        Task task = new Task(10);
        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    task.produce();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    task.consume();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producer.start();
        consumer.start();
    }

    private static class Task {
        private BlockingQueue<String> queue;

        public Task(int size) {
            queue = new ArrayBlockingQueue<>(size);
        }

        public void produce() throws InterruptedException {
            queue.put("Something !!!");
        }

        public void consume() throws InterruptedException {
            System.out.println("Consumed: " + queue.take() + ", RemainingCapacity: " + queue.remainingCapacity());

        }
    }
}
