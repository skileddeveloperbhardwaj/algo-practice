package multithreading.threadpool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorFrameworkPractice {
    private static ExecutorService executor = Executors.newSingleThreadExecutor();
    private static ScheduledExecutorService sExecutor = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        Runnable runnableTask = () -> {
          for(int i=0;i<100;i++) {
              System.out.println(Thread.currentThread().getName()+"  "+i);
          }
        };

        Callable<String> callableTask = () -> {
          Thread.sleep(3000);
          System.out.println("Task Execution");
          return "Task Execution";
        };

        for(int i=0;i<10;i++)
        executor.execute(runnableTask);

        executor.submit(callableTask);
        executor.shutdown();

        Integer[] arr = new Integer[]{2,1,3,4,2,3,0};
        Arrays.sort(arr, Integer::compareTo);
    }
}