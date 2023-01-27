package java8.javaUtilFunction.function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> length = s -> s.length();

        String goddess = "Marilyn Monroe";
        System.out.println(
                "Length of '" + goddess + "' is " + length.apply(goddess)); // Length of 'Marilyn Monroe' is 14

    }
}
