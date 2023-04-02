package buoi13.linkedQueue;

import java.util.*;
import java.util.concurrent.*;

public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
