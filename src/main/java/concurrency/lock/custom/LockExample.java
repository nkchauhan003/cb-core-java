package concurrency.lock.custom;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(new MyLock());
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
            for (int i = 0; i < 10000; i++) {
                counter.increment();
                System.out.println(getName() + ": " + counter.getCount());
            }
        }
    }

    private static class CounterDecrementer extends Thread {
        private Counter counter;

        public CounterDecrementer(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.decrement();
                System.out.println(getName() + ": " + counter.getCount());
            }
        }
    }

    private static class Counter {
        private MyLock lock;

        public Counter(MyLock lock) {
            this.lock = lock;
        }

        private int count;

        public int getCount() {
            return count;
        }

        public void increment() {
            lock.lock();
            count++;
            lock.unlock();
        }

        public synchronized void decrement() {
            lock.lock();
            count--;
            lock.unlock();
        }
    }
}






