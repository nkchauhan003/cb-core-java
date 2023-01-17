package concurrency.threadsafe;

public class Resources {
    public void someMethod() {
        // Thread safe local primitive variable
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
        someMethodC(stringBuffer);
    }

    public void someMethodC(StringBuilder stringBuffer) {
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
