package java8.javaUtilFunction.predicate;

import java.util.function.Predicate;

public class ComposedPredicate {
    public static void main(String[] args) {
        // default abstract method - Predicate<T> and(Predicate<? super T> other)

        Predicate<String> p1 = s -> s.contains("xyz");
        Predicate<String> p2 = s -> s.length() <= 5;

        Predicate<String> p1AndP2 = p1.and(p2);

        System.out.println(p1AndP2.test("bxyzc")); // true
        System.out.println(p1AndP2.test("abxyzc")); // false

        Predicate<String> p1OrP2 = p1.or(p2);

        System.out.println(p1OrP2.test("abcd")); // true
        System.out.println(p1OrP2.test("abxyzc")); // true
    }
}
