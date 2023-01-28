package java8.methodreference;

import java.util.function.Function;

public class UnboundedMethodReference {
    public static void main(String[] args) {
        // using lambda
        Function<String, String> fruitLm = s -> s.toUpperCase();
        System.out.println(fruitLm.apply("Apple")); // APPLE

        // using method reference
        Function<String, String> fruitRf = String::toUpperCase;
        System.out.println(fruitRf.apply("Apple")); // APPLE
    }
}
