package concurrency.threadsafe;

public class DataRace {

    private int a;
    private int b;
    private int c;

    // can execute out of order
    public void incrementBoth() {
        a++;
        b++;
    }

    // can not execute out of order because every line has dependency
    public void calculateBoth() {
        a = 1;
        b = a + 1;
        c = b - 1;
    }
}
