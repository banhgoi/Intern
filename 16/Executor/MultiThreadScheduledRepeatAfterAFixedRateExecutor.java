package executorforkjoin.Executor;

import executorforkjoin.Executor.Countdown;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MultiThreadScheduledRepeatAfterAFixedRateExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(3);//( 3 Thzead chạy với chu kỳ khác nhau
        Countdown clockl = new Countdown("A");
        Countdown clock2 = new Countdown("B");
        Countdown clock3 = new Countdown("C");

        scheduler.scheduleWithFixedDelay(clockl, 3, 1, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock2, 3, 2, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(clock3, 3, 3, TimeUnit.SECONDS);
    }
}
