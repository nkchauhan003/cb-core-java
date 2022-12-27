package concurrency.creation;

public class AnonymousRunnable {
    public static void main(String[] args) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started");
            }
        });
        th.start();
    }
}
