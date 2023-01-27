package java8.javaUtilFunction.unaryoperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<String> upperCase = s -> s.toUpperCase();
        System.out.println(upperCase.apply("techburps")); // TECHBURPS
    }
}
