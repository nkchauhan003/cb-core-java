package java8.javaUtilFunction.predicate;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {

        // functional method boolean test(T t)
        Predicate<String> contains = s -> s.contains("abc");
        // or Predicate<String> predicate = (String s) -> s.contains("abc");
        String input = "xyzabcuvw";
        System.out.println(input + " contains 'abc': " + contains.test(input)); // xyzabcuvw contains 'abc': true
    }
}
