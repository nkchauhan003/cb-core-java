package java8.defaultAndStaticMethods;

public class ImplB implements InterfaceWithConcreteMethods{

    // implemented and not overridden
    public static int doubleIt(int number) {
        return 2 * number;
    }

    /*
    Not allowed
    public default int multiply(int a, int b) {
        return a * b;
    }
    */

    @Override
    public String getName() {
        return "ImplA";
    }
}
