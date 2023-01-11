package concurrency.exercise.racecondition;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterIncrementer counterIncrementer = new CounterIncrementer(counter);
        CounterDecrementer counterDecrementer = new CounterDecrementer(counter);

        counterIncrementer.start();
        counterDecrementer.start();

        counterIncrementer.join();
        counterDecrementer.join();

        System.out.println("Count: " + counter.getCount());
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
        private int count;

        public int getCount() {
            return count;
        }

        public void increment() {
                count++;
        }

        public synchronized void decrement() {
                count--;
        }
    }
}






