package concurrency.lock.custom;

public class LockExample {
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

        MyLock myLock = new MyLock();
        private int count;

        public int getCount() {
            return count;
        }

        public void increment() {
            myLock.lock();
            count++;
            myLock.unlock();
        }

        public synchronized void decrement() {
            myLock.lock();
            count--;
            myLock.unlock();
        }
    }
}






