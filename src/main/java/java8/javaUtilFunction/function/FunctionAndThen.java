package java8.javaUtilFunction.function;

import java.util.function.Function;

public class FunctionAndThen {
    public static void main(String[] args) {
        Function<Double, Double> doubleMe = n -> 2 * n;
        Function<Double, Double> addFive = n -> 5 + n;
        Function<Double, Double> divideMe = n -> n / 2;

        Function<Double, Double> composed = doubleMe.andThen(addFive).andThen(divideMe);

        // ((2 * 10) + 5) / 2 = 12.5
        System.out.println(composed.apply(10.0)); // 12.5
    }
}
