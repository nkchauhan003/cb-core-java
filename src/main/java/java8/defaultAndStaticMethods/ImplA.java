package java8.defaultAndStaticMethods;

public class ImplA implements InterfaceWithConcreteMethods {
    @Override
    public String getName() {
        return "ImplA";
    }
    // no need to implement "static" or "default" methods
}
