package java8.javaUtilFunction.bipredicate;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static <T, U> boolean checkIt(T t, U u, BiPredicate<T, U> predicate) {
        return predicate.test(t, u);
    }

    public static void main(String[] args) {
        BiPredicate<String, Integer> checkLength = (s, n) -> s.length() == n;


        BiPredicate<Integer, Integer> isDividedBy = (n1, n2) -> n1 % n2 == 0;
        BiPredicate<Integer, Integer> isEquals = (n1, n2) -> n1 == n2;

        //and
        BiPredicate<Integer, Integer> isDividedByAndIsEquals = isDividedBy.and(isEquals);
        System.out.println(checkIt(10, 2, isDividedByAndIsEquals)); // false
        System.out.println(checkIt(10, 10, isDividedByAndIsEquals)); // true

        //or
        BiPredicate<Integer, Integer> isDividedByOrIsEquals = isDividedBy.or(isEquals);
        System.out.println(checkIt(10, 2, isDividedByOrIsEquals)); // true
        System.out.println(checkIt(10, 10, isDividedByOrIsEquals)); // true

        //negate
        System.out.println(checkIt(10, 2, isDividedByOrIsEquals.negate())); // false
    }
}
