package executorforkjoin.Executor;

import java.util.concurrent.*;

public class SimpleScheduledExecutor_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Callable<Integer> task = new Callable<Integer>() {
            public Integer call() {
                // fake computation time
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return 10000;
            }
        };
        int delay = 2;
        Future<Integer> result = scheduler.schedule(task, delay, TimeUnit.SECONDS);
        try {
            Integer value = result.get();
            System.out.println("valne = " + value);

        } catch (InterruptedException | ExecutionException ex) {

            ex.printStackTrace();
        }

        scheduler.shutdown();
    }

}