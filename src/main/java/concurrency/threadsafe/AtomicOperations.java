package concurrency.threadsafe;

public class AtomicOperations {

    public void methodA() {
        Object o1 = new Object();
        Object o2 = new Object();

        o1 = o2; // an atomic operation
    }

    public void methodB() {
        int a = 10;
        int b = 5;
        a = b; // an atomic operation

        long c = 10;
        long d = 5;
        c = d; // may not be atomic
    }

    public void methodC() {
        int a = 10;
        int b = 5;
        a = b; // an atomic operation

        int c = 10;
        int d = 5;
        c = d; // may not be atomic
    }

}
