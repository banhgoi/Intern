package executorforkjoin.Executor;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Countdown implements Runnable {
    String name;

    public Countdown(String name) {
        this.name = name;
    }

    public Countdown() {
    }

    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void run() {
        System.out.println("Clock "+name);
    }
}


