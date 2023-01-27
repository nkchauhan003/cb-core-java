package java8.javaUtilFunction.bifunction;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (n, m) -> n + m;

        int a = 10, b = 20;
        System.out.println(
                "Sum of '" + a + "' and '" + b + "' is: " + sum.apply(a, b)); // Sum of '10' and '20' is: 30
    }
}
