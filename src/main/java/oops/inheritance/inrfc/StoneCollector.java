package oops.inheritance.inrfc;

public class StoneCollector implements Collectable {
    @Override
    public void collect() {
        System.out.println("Collected !!!");
    }

    @Override
    public void printName() {
        System.out.println("Whatever not !!!");
    }
}
