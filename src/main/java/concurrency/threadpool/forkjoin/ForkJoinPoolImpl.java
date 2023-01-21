package concurrency.threadpool.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolImpl {
    public static void main(String[] args) {
        int proc = Runtime.getRuntime().availableProcessors();

        System.out.println("Available cores: " + proc);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        int result = pool.invoke(new SummingTask(linkedList()));
        System.out.println("Result: " + result);

        System.out.println("Pool Size: " + pool.getPoolSize());
    }

    public static class SummingTask extends RecursiveTask<Integer> {

        private final Node node;

        public SummingTask(Node node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return node == null ? 0 : node.value + new SummingTask(node.next).fork().join();
        }
    }

    private static Node linkedList() {
        return new Node(10, new Node(20, new Node(30, new Node(40, new Node(50, null)))));
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
