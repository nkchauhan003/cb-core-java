package oops.inheritance.cls;

public class Apple extends Fruit {

    @Override
    public void printName() {
        System.out.println("Apple.");
    }

    // static methods can not be overridden
    public static void printColor() {
        System.out.println("Fruit.");
    }

    public void printPrice() {
        System.out.println("10 rs/kg.");
    }

    public boolean isHealthy() {
        // superclass members i.e. isHealthy, can be used directly in a subclass
        return !isHealthy;
    }

}
