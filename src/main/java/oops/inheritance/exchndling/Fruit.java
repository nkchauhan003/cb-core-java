package oops.inheritance.exchndling;

import java.io.IOException;

public class Fruit {
    public double getValue(double weight, double price) {
        return weight * price;
    }

    public void printSize() throws IOException {
        System.out.println("Big Enough !!!");
    }

    public void printWeight() throws ClassNotFoundException {
        System.out.println("Heavy !!!");
    }

}
