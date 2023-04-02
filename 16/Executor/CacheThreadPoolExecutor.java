package executorforkjoin.Executor;

import java.util.concurrent.*;

public class CacheThreadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute( new Countdown("A"));
        pool.execute( new Countdown("B"));

        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 10; i >= 0; i--) {
                    System.out.println("Callable " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return 1000;
            }
        };
        pool.submit(task);
        Future<Integer> rs = pool.submit(task);
        try {
            Integer returnV = rs.get();
            System.out.println("ReturnValue " + returnV);
        } catch (ExecutionException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        pool.shutdown();
    }
}
