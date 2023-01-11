package oops.inheritance.cls;

import java.util.ArrayList;

public class Apple extends Fruit {

    @Override
    public void printName() {
        System.out.println("Apple.");
    }

    // Static methods can not be overridden
    public static void printColor() {
        System.out.println("RED.");
    }

    public void printPrice() {
        System.out.println("10 rs/kg.");
    }

    public boolean isHealthy() {
        // superclass members i.e. isHealthy, can be used directly in a subclass
        return !isHealthy;
    }

    // An overriding method can also return a subtype of the type returned by the overridden method
    @Override
    public ArrayList getNames() {
        return null;
    }
}
