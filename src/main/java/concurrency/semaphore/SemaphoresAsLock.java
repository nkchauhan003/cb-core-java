package concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoresAsLock {
    public static void main(String[] args) throws InterruptedException {
        Semaphore binarySemaphore = new Semaphore(1);
        Counter counter = new Counter(binarySemaphore);
        CounterIncrementer counterIncrementer = new CounterIncrementer(counter);
        CounterDecrementer counterDecrementer = new CounterDecrementer(counter);

        counterIncrementer.start();
        counterDecrementer.start();

        counterIncrementer.join();
        counterDecrementer.join();

        System.out.println("Count: " + counter.getCount()); // 0
    }

    private static class CounterIncrementer extends Thread {
        private Counter counter;

        public CounterIncrementer(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 10000; i++)
                counter.increment();

        }
    }

    private static class CounterDecrementer extends Thread {
        private Counter counter;

        public CounterDecrementer(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 10000; i++)
                counter.decrement();
        }
    }

    private static class Counter {
        private Semaphore semaphore;
        private int count;

        public Counter(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            try {
                semaphore.acquire();
                count++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }

        public synchronized void decrement() {
            try {
                semaphore.acquire();
                count--;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }
    }
}
