package System;
import obj.Order;
import obj.Stock;
import obj.Trader;
import obj.Transaction;

import java.util.*;

import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class index {
    static final private Integer queueDelay = 10,
            numberOfSellThread = 5,
            numberOfBuyThread = 3,
            totalThread = numberOfBuyThread + numberOfSellThread + 1;
    static public AtomicInteger orderId = new AtomicInteger(1);
    static public AtomicInteger transactionId = new AtomicInteger(1);

    public static void main(String[] args) {
        SellQueueComparator sellQueueComparator = new SellQueueComparator();
        BuyQueueComparator buyQueueComparator = new BuyQueueComparator();
        HashMap<Stock, PriorityBlockingQueue<Order>> sellQueue = new HashMap<>();
        HashMap<Stock, PriorityBlockingQueue<Order>> buyQueue = new HashMap<>();
        List<Transaction> transactions = new ArrayList<>(100);


        List<Stock> stocks = new ArrayList<>(3);
        stocks.add(new Stock("flc"));
        stocks.add(new Stock("ctd"));
        stocks.add(new Stock("ctg"));

        List<Trader> traders=new ArrayList<>(3);
        traders.add(new Trader("kh1td1"));
        traders.add(new Trader("kh2td1"));
        traders.add(new Trader("kh3td1"));

        for (int i = 0; i < stocks.size(); i++) {
            sellQueue.put(stocks.get(i), new PriorityBlockingQueue<>(10, sellQueueComparator));
            buyQueue.put(stocks.get(i), new PriorityBlockingQueue<>(10, buyQueueComparator));
        }

        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(totalThread);
        List<SellThread> sellThreads = new ArrayList<>(numberOfSellThread);
        List<BuyThread> buyThreads = new ArrayList<>(numberOfBuyThread);

        for (int i = 0; i < numberOfSellThread; i++)
            sellThreads.add(new SellThread(sellQueue, stocks, traders));

        for (int i = 0; i < numberOfBuyThread; i++)
            buyThreads.add(new BuyThread(buyQueue, stocks, traders));

        Matching matching = new Matching(sellQueue, buyQueue, transactions);

        for (SellThread thread : sellThreads)
            scheduled.scheduleWithFixedDelay(thread, 0, queueDelay, TimeUnit.SECONDS);

        for (BuyThread thread : buyThreads)
            scheduled.scheduleWithFixedDelay(thread, 0, queueDelay, TimeUnit.SECONDS);

        scheduled.scheduleWithFixedDelay(matching, 0, queueDelay, TimeUnit.SECONDS);
//        scheduled.shutdown();

    }
}

class SellQueueComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return - (new Double(o1.getPrice()).compareTo(o2.getPrice()));
    }
}

class BuyQueueComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return new Double(o1.getPrice()).compareTo(o2.getPrice());
    }
}