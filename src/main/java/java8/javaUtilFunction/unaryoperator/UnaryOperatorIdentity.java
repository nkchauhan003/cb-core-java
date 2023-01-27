package java8.javaUtilFunction.unaryoperator;

import java.util.function.UnaryOperator;

public class UnaryOperatorIdentity {
    public static void main(String[] args) {
        UnaryOperator<String> identity = UnaryOperator.identity();
        System.out.println(identity.apply("Apple")); // Apple
    }
}
