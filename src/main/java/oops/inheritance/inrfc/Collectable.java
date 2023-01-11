package oops.inheritance.inrfc;

public interface Collectable {

    public default void printName() {
        System.out.println("Whatever !!!");
    }

    public void collect();
}
