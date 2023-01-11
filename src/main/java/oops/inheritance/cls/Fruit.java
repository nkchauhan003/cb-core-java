package oops.inheritance.cls;

import java.util.List;

public class Fruit {
    boolean isHealthy = true;

    // Subclass can not access private members of its super class
    private void isFruit() {
        System.out.println("I am privately a fruit at heart.");
    }

    public void printSize() {
        System.out.println("Big Enough !!!");
    }

    public void printName() {
        System.out.println("Fruit.");
    }

    public static void printColor() {
        System.out.println("Fruit.");
    }

    public List getNames() {
        return null;
    }
}
