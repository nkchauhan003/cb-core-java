package java8.methodreference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Guava");

        // using "Lambda"
        fruits.stream().forEach(name -> System.out.println(name));

        // using "Method reference"
        fruits.stream().forEach(System.out::println);
    }
}
