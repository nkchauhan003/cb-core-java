package oops.inheritance.exchndling;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Apple extends Fruit {

    /*
    If superclass does not declare an exception, then the subclass can only declare unchecked exceptions, but not the checked exceptions.
    */
    @Override
    public double getValue(double weight, double price) throws ArithmeticException {
        return 2 * weight * price;
    }

    /*
    If superclass declares an exception, then the subclass can only declare the same or child exceptions or no exception at all.
    The subclass can also declare any new Runtime Exceptions, but not any new checked exceptions.
    */

    public void printSize() throws FileNotFoundException, RuntimeException {
        System.out.println("Big Enough !!!");
    }

    /*
    Not allowed

    public void printSize() throws SQLException {
        System.out.println("Big Enough !!!");
    }

    public void printSize() throws Exception {
        System.out.println("Big Enough !!!");
    }

    */

    /*
    If superclass declares an exception, then the subclass can declare without exception.
    */
    public void printWeight() {
        System.out.println("Heavy !!!");
    }
}
