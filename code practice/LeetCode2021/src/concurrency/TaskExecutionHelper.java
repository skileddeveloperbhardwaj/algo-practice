package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionHelper {
    private static final Executor exec = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException{
        while (true) {
            Runnable task = () -> {System.out.println(Thread.currentThread().getName());};
            exec.execute(task);
            Thread.sleep(500);
        }
    }
}
