package executorforkjoin.Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimpleScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
        Runnable task =new Runnable() {
            @Override
            public void run() {
                System.out.println("Chay sau 2s");
            }
        };

        int delay =2;
        scheduled.schedule(task, delay, TimeUnit.SECONDS);
        scheduled.shutdown();
    }
}
