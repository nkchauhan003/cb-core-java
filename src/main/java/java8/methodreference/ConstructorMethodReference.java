package java8.methodreference;

import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {
        // using lambda
        Supplier<StringBuilder> supplierLd = () -> new StringBuilder();
        StringBuilder stringBuilderLd = supplierLd.get();
        stringBuilderLd.append("Hello !!");
        System.out.println(stringBuilderLd); // Hello !!

        // using method reference
        Supplier<StringBuilder> supplierMr = StringBuilder::new;
        StringBuilder stringBuilderMr = supplierMr.get();
        stringBuilderMr.append("Hello !!");
        System.out.println(stringBuilderMr); // Hello !!
    }
}
