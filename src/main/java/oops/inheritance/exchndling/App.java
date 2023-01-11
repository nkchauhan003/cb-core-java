package oops.inheritance.exchndling;


import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // apple is a fruit
        Fruit fruit = new Apple();
        fruit.getValue(10.3, 98);
        fruit.printSize();
        fruit.printWeight();
    }
}
