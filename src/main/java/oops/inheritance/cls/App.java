package oops.inheritance.cls;

public class App {
    public static void main(String[] args) {
        // With superclass reference
        Fruit fruit = new Apple();

        // Private members of a SuperClass are not visible to an instance of SubClass
        // fruit.isFruit(); -- not possible

        // SubClass can call non-private superclass members as its own
        fruit.printSize(); // Big Enough !!!

        // Overridden method will be called irrespective of reference variable type
        fruit.printName(); // Apple.

        // method not present in superclass can not be called with superclass reference
        // fruit.printPrice(); -- not possible

        // not overridden, calling one from the reference type class
        fruit.printColor(); // BLACK
        Fruit.printColor(); // BLACK

        // With subclass reference
        Apple apple = new Apple();

        // Private members of a SuperClass are not visible to an instance of SubClass
        // apple.isFruit(); -- not possible

        // SubClass can call non-private superclass members as its own
        apple.printSize();

        // Overridden method will be called irrespective of reference variable type
        apple.printName(); // Apple.

        // method not present in superclass
        apple.printPrice(); // 10 rs/kg.

        Apple.printColor(); // RED
        apple.printColor(); // RED
    }
}
