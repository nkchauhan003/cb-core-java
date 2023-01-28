package java8.methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaContext {
    public static void main(String[] args) {
        Supplier<Integer> count = () -> Counter.count();
        System.out.println(count.get()); // 0

        Function<String, Integer> countFn = s -> Counter.count(s);
        System.out.println(countFn.apply("Apple")); // 1

        BiFunction<String, String, Integer> countBFn = (s1, s2) -> Counter.count(s1, s2);
        System.out.println(countBFn.apply("Apple", "Orange")); // 2
    }

    private static class Counter {
        public static int count(String... instances) {
            return instances.length;
        }
    }
}
