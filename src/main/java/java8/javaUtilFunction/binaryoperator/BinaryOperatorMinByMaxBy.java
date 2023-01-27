package java8.javaUtilFunction.binaryoperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorMinByMaxBy {
    public static void main(String[] args) {
        BinaryOperator<Integer> minByA = BinaryOperator.minBy((a, b) -> a.compareTo(b));
        System.out.println(minByA.apply(10, 20)); // 10

        BinaryOperator<Integer> minByB = BinaryOperator.minBy((a, b) -> b.compareTo(a));
        System.out.println(minByB.apply(10, 20)); // 20

        BinaryOperator<Integer> maxByA = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        System.out.println(maxByA.apply(10, 20)); // 20

        BinaryOperator<Integer> maxByB = BinaryOperator.maxBy((a, b) -> b.compareTo(a));
        System.out.println(maxByB.apply(10, 20)); // 10
    }
}
