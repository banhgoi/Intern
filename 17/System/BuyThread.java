package System;


import obj.Order;
import obj.Stock;
import obj.Trader;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class BuyThread implements Runnable{
    private HashMap<Stock, PriorityBlockingQueue<Order>> buyQueue;
    private final List<Stock> stocks;
    private final List<Trader> traders;

    public BuyThread(HashMap<Stock, PriorityBlockingQueue<Order>> buyQueue, List<Stock> stocks,  List<Trader> traders) {
        this.buyQueue = buyQueue;
        this.stocks = stocks;
        this.traders=traders;
    }

    @Override
    public void run() {
        Integer id,  amount, price;
        String traderId;
        Random generator = new Random();
        Stock stock;
        Boolean type;
        String stockCode;
        Date now;

        id = index.orderId.getAndAdd(1);
        now         = new Date();
        stock       = stocks.get(generator.nextInt(5));
        traderId    = traders.get(generator.nextInt(5)).getIDTrader();
        type        = false; //buy
        stockCode   = stock.getIDStock();
        amount      = generator.nextInt(100) + 100;
        price       = generator.nextInt(10) + 10;

        Order order = new Order(id, now.toString(), traderId, stockCode, amount, price, type);
        buyQueue.get(stock).add(order);
        System.out.println("Tạo thành công: " + order);
    }
}