package java8.javaUtilFunction.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printName = name -> System.out.println("My Name is: " + name);
        Consumer<String> printNameInBlockLetters = name -> System.out.println(("My Name is: " + name.toUpperCase()));

        // andThen
        Consumer<String> printComposedName = printName.andThen(printNameInBlockLetters);
        printComposedName.accept("Leonardo DiCaprio");
    }
}
