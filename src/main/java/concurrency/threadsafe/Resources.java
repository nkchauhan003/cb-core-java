package concurrency.threadsafe;

public class Resources {
    public void someMethod() {

        // Thread safe primitive variable
        int value = 0;
        value++;
    }

    public void someMethodA() {
        // Thread safe object
        StringBuilder stringBuffer = new StringBuilder("Techburps");
        stringBuffer.toString();
    }

    public void someMethodB() {
        // Thread safe object
        StringBuilder stringBuffer = new StringBuilder("Tech");
        stringBuffer.append("burps");
        someMethodB(stringBuffer);
    }

    public void someMethodB(StringBuilder stringBuffer) {
        stringBuffer.toString();
    }

    public class Hello {
        int noOfHellos = 0;

        // Not thread safe
        public void increment() {
            noOfHellos++;
        }
    }
}
