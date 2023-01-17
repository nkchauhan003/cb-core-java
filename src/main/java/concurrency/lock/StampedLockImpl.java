package concurrency.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class StampedLockImpl {

    public static void main(String[] args) {
        Items items = new Items();
        Thread itemWriter = new ItemWriter(items);
        itemWriter.setName("Writer");

        Thread itemReader1 = new ItemReader(items);
        itemReader1.setName("Reader-1");

        Thread itemReader2 = new ItemReader(items);
        itemReader2.setName("Reader-2");

        Thread itemOptimisticReader = new ItemOptimisticReader(items);
        itemReader2.setName("Optimistic Reader");

        itemWriter.start();
        itemReader1.start();
        itemReader2.start();
        itemOptimisticReader.start();
    }

    private static class ItemWriter extends Thread {
        private Items items;

        public ItemWriter(Items items) {
            this.items = items;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                items.addElement(i);
            }
        }
    }

    private static class ItemReader extends Thread {
        private Items items;

        public ItemReader(Items items) {
            this.items = items;
        }

        public void run() {
            for (int i = 0; i < 5; i++)
                items.getElement(i);
        }
    }

    private static class ItemOptimisticReader extends Thread {
        private Items items;

        public ItemOptimisticReader(Items items) {
            this.items = items;
        }

        public void run() {
            for (int i = 0; i < 5; i++)
                items.optimisticGetElement(i);
        }
    }

    private static class Items {
        private List<Integer> list = new ArrayList<>();
        private StampedLock stampedLock = new StampedLock();

        public void addElement(Integer integer) {
            long stamp = stampedLock.writeLock();
            try {
                System.out.println("Added by: " + Thread.currentThread().getName());
                list.add(integer);
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        }

        public Integer getElement(int index) {
            long stamp = stampedLock.readLock();
            try {
                System.out.println("Get by: " + Thread.currentThread().getName());
                return list.get(index);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        public Integer optimisticGetElement(int index) {
            // does no locking
            long stamp = stampedLock.tryReadLock();
            int localValue = index;

            // make sure, some other thread didn't change anything
            if (stampedLock.validate(stamp))
                return localValue;

            // wait for lock to acquire
            stamp = stampedLock.readLock();
            try {
                System.out.println("Get by: " + Thread.currentThread().getName());
                return list.get(index);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
    }
}
