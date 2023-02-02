package concurrency.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static int size = 10;

    public static void main(String[] args) {
        Task task = new Task();
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

    private static class Task extends Thread {
        private Queue<String> queue = new LinkedList<>();

        public synchronized void produce() throws InterruptedException {
            while (queue.size() == size) wait();
            System.out.println("Produced: " + queue.add("Something !!!") + " : " + queue.size());
            notify();
        }

        public synchronized void consume() throws InterruptedException {
            while (queue.isEmpty()) wait();
            System.out.println("Consumed: " + queue.remove() + " : " + queue.size());
            notify();
        }
    }
}
