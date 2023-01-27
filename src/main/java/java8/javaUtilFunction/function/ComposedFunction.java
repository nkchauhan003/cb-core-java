package java8.javaUtilFunction.function;

import java.util.function.Function;

public class ComposedFunction {
    public static void main(String[] args) {
        Function<Double, Double> doubleMe = n -> 2 * n;
        Function<Double, Double> tripleMe = n -> 3 * n;
        Function<Double, Double> divideMe = n -> n / 2;

        Function<Double, Double> composed = doubleMe.compose(tripleMe).compose(divideMe);

        // ((10/2) * 3) * 2 = 30.0
        System.out.println(composed.apply(10.0)); // 30.0

    }
}
