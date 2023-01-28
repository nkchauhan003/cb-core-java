package java8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StaticMethodReferences {
    public static void main(String[] args) {

        // using lambda
        List<String> fruitsLd = Arrays.asList("Banana", "Apple", "Orange", "Guava");
        Consumer<List<String>> sortLd = s -> Collections.sort(s);
        sortLd.accept(fruitsLd);
        System.out.println(fruitsLd); // [Apple, Banana, Guava, Orange]

        // using "Method reference"
        List<String> fruitsMr = Arrays.asList("Banana", "Apple", "Orange", "Guava");
        Consumer<List<String>> sortMr = Collections::sort;
        sortMr.accept(fruitsMr);
        System.out.println(fruitsMr); // [Apple, Banana, Guava, Orange]
    }
}
