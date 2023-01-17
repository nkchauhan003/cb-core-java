package concurrency.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockImpl {
    public static void main(String[] args) {
        Items items = new Items();
        Thread itemWriter = new ItemWriter(items);
        itemWriter.setName("Writer");

        Thread itemReader1 = new ItemReader(items);
        itemReader1.setName("Reader-1");

        Thread itemReader2 = new ItemReader(items);
        itemReader2.setName("Reader-2");

        itemWriter.start();
        itemReader1.start();
        itemReader2.start();
    }

    private static class ItemWriter extends Thread {
        private Items items;

        public ItemWriter(Items items) {
            this.items = items;
        }

        public void run() {
            for (int i = 0; i < 5; i++)
                items.addElement(i);
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

    private static class Items {
        private List<Integer> list = new ArrayList<>();
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private Lock readLock = readWriteLock.readLock();
        private Lock writeLock = readWriteLock.writeLock();

        public void addElement(Integer integer) {
            writeLock.lock();
            try {
                System.out.println("Added by: " + Thread.currentThread().getName());
                list.add(integer);
            } finally {
                writeLock.unlock();
            }
        }

        public Integer getElement(int index) {
            readLock.lock();
            try {
                System.out.println("Get by: " + Thread.currentThread().getName());
                return list.get(index);
            } finally {
                readLock.unlock();
            }
        }
    }
}
