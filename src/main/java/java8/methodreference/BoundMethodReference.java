package java8.methodreference;

import java.util.function.Supplier;

public class BoundMethodReference {
    public static void main(String[] args) {
        String fruit = "Apple";

        // using lambda
        Supplier<String> fruitLm = fruit::toUpperCase;
        System.out.println(fruitLm.get()); // APPLE

        // using method reference
        Supplier<String> fruitMr = () -> fruit.toUpperCase();
        System.out.println(fruitMr.get()); // APPLE
    }
}
