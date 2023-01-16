package concurrency.threadsafe;

public class AtomicOperations {

    Object o1 = new Object();
    Object o2 = new Object();

    public void methodA() {
        o1 = o2; // an atomic operation
    }

    int a = 10;
    int b = 5;
    long c = 10;
    long d = 5;

    public void methodB() {
        a = b; // an atomic operation
        c = d; // may not be atomic
    }

    volatile long e = 10;
    volatile long f = 5;

    public void methodC() {
        c = d; // an atomic operation
    }

}
