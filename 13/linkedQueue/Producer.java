package buoi13.linkedQueue;

import java.util.*;
import java.util.concurrent.*;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                Integer number = produce();
                boolean success = queue.offer(number, 100, TimeUnit.MILLISECONDS);

                if (success) {
                    System.out.println("PRODUCER: created " + number);
                } else {
                    System.out.println("PRODUCER: gave up");
                }
            }
            queue.put(-1);       // indicates end of producing
            System.out.println("PRODUCER: STOPPED.");

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private Integer produce() {
        Random random = new Random();
        Integer number = random.nextInt(100);

        // fake producing time
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        return number;
    }
}
