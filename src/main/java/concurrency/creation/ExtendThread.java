package concurrency.creation;

public class ExtendThread {
    public static void main(String[] args) {

        // instance of Thread's subclass
        Thread thread = new ThreadB();

        // starting a thread by calling start() on subclass
        thread.start();
    }

    // extending 'java.lang.Thread'
    private static class ThreadB extends Thread {
        @Override
        public void run() {
            System.out.println("Thread started: " + this.getName());
        }
    }
}
