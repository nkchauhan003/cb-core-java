package java8.javaUtilFunction.predicate;

import java.util.function.Predicate;

public class PredicateAsParameter {
    // Passing "Predicate" as a parameter
    public static <T> boolean checkIt(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static void main(String[] args) {
        // Passing "Predicate" as a parameter
        System.out.println(checkIt("abc", (String s) -> s.contains("abc"))); // true
        System.out.println(checkIt(7, (Integer s) -> s % 2 == 0)); // false
    }
}
