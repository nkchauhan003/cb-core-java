package java8.javaUtilFunction.biconsumer;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printDetails = (name, age) -> System.out.println(
                "My Name is '" + name + "', I am '" + age + "'.");
        BiConsumer<String, Integer> printDetailsInCaps = (name, age) -> System.out.println(
                "My Name is '" + name.toUpperCase() + "', I am '" + age + "'.");

        // andThen
        BiConsumer<String, Integer> printComposedDetails = printDetails.andThen(printDetailsInCaps);
        printComposedDetails.accept("Leonardo DiCaprio", 32);
    }
}
