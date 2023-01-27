package java8.defaultAndStaticMethods;

public interface InterfaceWithConcreteMethods {

    // abstract method
    String getName();

    // 'static' concrete method
    static int doubleIt(int number) {
        return 2 * number;
    }

    // 'default' concrete method
    default int multiply(int a, int b) {
        return a * b;
    }




}
