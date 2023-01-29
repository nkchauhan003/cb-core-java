package java8.methodreference;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConstructorReference {
    public static void main(String[] args) {
        // using lambda
        Supplier<StringBuilder> supplierLd = () -> new StringBuilder();
        StringBuilder stringBuilderLd = supplierLd.get();
        stringBuilderLd.append("Hello !!");
        System.out.println(stringBuilderLd); // Hello !!

        // using constructor reference
        Supplier<StringBuilder> supplierMr = StringBuilder::new;
        StringBuilder stringBuilderMr = supplierMr.get();
        stringBuilderMr.append("Hello !!");
        System.out.println(stringBuilderMr); // Hello !!

        // constructor reference with parameter(s)
        BiFunction<Integer,String,User> userMr = User::new;
        User user = userMr.apply(1,"Adam");
        System.out.println(user); // User{id=1, name='Adam', age=0}
    }
}
