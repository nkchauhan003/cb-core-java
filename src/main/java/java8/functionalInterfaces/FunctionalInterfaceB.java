package java8.functionalInterfaces;

@FunctionalInterface
public interface FunctionalInterfaceB {

    // single abstract method
    String getName();

    // 'static' concrete method
    static int doubleIt(int number) {
        return 2 * number;
    }

    // 'default' concrete method
    default int multiply(int a, int b) {
        return a * b;
    }

    /*
     *  In 'Object' class -
     *
     *  @IntrinsicCandidate
     *  public native int hashCode();
     *
     * */
    @Override
    int hashCode();
}
