package bonus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void run(int option, int numberTasks, int numberThreads)
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberThreads);

        for (int i = 1; i <= numberTasks; i++) {
            Task task = new Task(i, "SELECT * FROM movies WHERE id in (1, 2);", option);
            System.out.println("Created: " + i);
            executor.execute(task);
        }

        executor.shutdown();
    }
}