package executorforkjoin.Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadScheduledRepeatAfterAFixedRateExecutor implements Runnable {
    public void run() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable task = new ThreadScheduledRepeatAfterAFixedRateExecutor();
        int initialDelay = 4000;  // Sau 4 giây thì bắt đầu chương trình

        int periodicDelay = 1000;// Sau 1000 mili giây lại lặp lại

        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
                TimeUnit.MILLISECONDS);
    }
}