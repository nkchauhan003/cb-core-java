package concurrency.threadclass.methods;

public class InterruptingThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for(int i=0;i<100;i++){
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("The thread is interrupted !!!");
                    break;
                }
                System.out.print(i+" ");
            }
        });
        thread.start();
        thread.interrupt();
    }
}
