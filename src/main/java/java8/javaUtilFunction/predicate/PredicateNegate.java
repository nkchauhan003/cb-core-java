package java8.javaUtilFunction.predicate;

import java.util.function.Predicate;

public class PredicateNegate {
    public static <T> boolean checkIt(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static void main(String[] args) {
        Predicate<Integer> isEven = s -> s % 2 == 0;

        System.out.println("Is even: " + checkIt(4, isEven)); // true
        System.out.println("Is even: " + checkIt(4, isEven.negate())); // false
    }
}
