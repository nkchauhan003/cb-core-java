package java8.javaUtilFunction.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndThen {
    public static void main(String[] args) {
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        Function<String, String> upperCase = s -> s.toUpperCase();

        BiFunction<String, String, String> composed = concat.andThen(upperCase);
        System.out.println(composed.apply("Tech", "Burps")); // TECHBURPS
    }
}
