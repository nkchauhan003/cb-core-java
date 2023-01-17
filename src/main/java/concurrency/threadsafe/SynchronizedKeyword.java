package concurrency.threadsafe;

public class SynchronizedKeyword {
    private int count;

    // on instance method
    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    // on instance block
    public void incrementBlock() {
        synchronized (this) {
            count++;
        }
    }

    public void decrementBlock() {
        synchronized (this) {
            count--;
        }
    }

    // on instance block different object
    SynchronizedKeyword synchronizedKeyword1 = new SynchronizedKeyword();
    SynchronizedKeyword synchronizedKeyword2 = new SynchronizedKeyword();

    public void incrementBlockA() {
        synchronized (synchronizedKeyword1) {
            count++;
        }
    }

    public void decrementBlockA() {
        synchronized (synchronizedKeyword2) {
            count--;
        }
    }

    private static int staticCount;

    // on static method
    public static synchronized void incrementStatic() {
        staticCount++;
    }

    public static synchronized void decrementStatic() {
        staticCount--;
    }

    // block in static method
    public static void incrementStaticBlock() {
        synchronized (SynchronizedKeyword.class) {
            staticCount++;
        }
    }

    public static synchronized void decrementStaticBlock() {
        synchronized (SynchronizedKeyword.class) {
            staticCount--;
        }
    }

    //Reentrance
    public synchronized void methodX() {
        methodY();
    }

    public synchronized void methodY() {
        // do something
    }
}
