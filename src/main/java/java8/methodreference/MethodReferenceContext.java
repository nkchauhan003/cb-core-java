package java8.methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceContext {
    public static void main(String[] args) {
        Supplier<Integer> count = Counter::count;
        System.out.println(count.get()); // 0

        Function<String, Integer> countFn = Counter::count;
        System.out.println(countFn.apply("Apple")); // 1

        BiFunction<String, String, Integer> countBFn = Counter::count;
        System.out.println(countBFn.apply("Apple", "Orange")); // 2

    }

    private static class Counter {
        public static int count(String... instances) {
            return instances.length;
        }
    }
}
