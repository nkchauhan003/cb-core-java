package java8.lambda;

public class LambdasDemoA {
    @FunctionalInterface
    interface Doubler<U, V> {
        // single abstract method
        V doubleIt(U u);
    }

    public static void main(String[] args) {
        Doubler<String, String> stringDoubler = (s1) -> s1 + s1;
        Doubler<Integer, Long> intDoubler = (s1) -> Long.valueOf(2 * s1);

        // use {} for multiline implementation
        Doubler<Integer, Long> intDoublerMultiLine = (s1) -> {
            int v = 2 * s1;

            // with Java >= 10
            //var v = 2 * s1;
            
            return Long.valueOf(v);
        };

        /*
         * Not valid - Cannot infer type: lambda expression requires an explicit target type
         *
         * var intDoubler = (s1) -> Long.valueOf(2 * s1);
         */
    }
}
