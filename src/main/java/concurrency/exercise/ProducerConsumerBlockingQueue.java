package concurrency.exercise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Thread producer1 = new Producer(queue);
        Thread producer2 = new Producer(queue);

        Thread consumer1 = new Consumer(queue);
        Thread consumer2 = new Consumer(queue);

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
    }

    private static class Producer extends Thread {

        private BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    queue.put("Something !!!");
                    System.out.println(
                            "Produced: " + currentThread().getName() + ", RemainingCapacity: " + queue.remainingCapacity());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class Consumer extends Thread {

        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                    System.out.println(
                            "Consumed: " + currentThread().getName() + ", RemainingCapacity: " + queue.remainingCapacity());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
