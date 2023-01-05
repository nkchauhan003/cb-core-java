package concurrency.exercise;

import java.util.List;

public class TbExecutor {
    private List<Runnable> tasks;

    public TbExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void execute() {
        for (Runnable runnable : tasks) {
            new Thread(runnable).start();
        }
    }
}

class Client {
    public static void main(String[] args) {
        List<Runnable> tasks = List.of(
                () -> System.out.println("Name: " + Thread.currentThread().getName()),
                () -> System.out.println("Name: " + Thread.currentThread().getName()),
                () -> System.out.println("Name: " + Thread.currentThread().getName()),
                () -> System.out.println("Name: " + Thread.currentThread().getName())
        );
        TbExecutor tbExecutor = new TbExecutor(tasks);
        tbExecutor.execute();
    }
}
