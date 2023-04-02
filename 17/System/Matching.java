package System;
import obj.Order;
import obj.Stock;
import obj.Transaction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class Matching implements Runnable{
    private final HashMap<Stock, PriorityBlockingQueue<Order>> hmSellQueue;
    private final HashMap<Stock, PriorityBlockingQueue<Order>> hmBuyQueue;
    private final List<Transaction> transactions;

    public Matching(HashMap<Stock, PriorityBlockingQueue<Order>> hmSellQueue, HashMap<Stock, PriorityBlockingQueue<Order>> hmBuyQueue, List<Transaction> transactions) {
        this.hmSellQueue = hmSellQueue;
        this.hmBuyQueue = hmBuyQueue;
        this.transactions = transactions;
    }

    @Override
    public void run() {
        PriorityBlockingQueue<Order> buyQueue;
        PriorityBlockingQueue<Order> sellQueue;
        Order buyOrder, sellOrder;
        Integer transactionId,  amount, orderBuyId, orderSellId;
        Double price;

        Date date;
        String stockCode;
        for (Stock s : hmBuyQueue.keySet()) {
            buyQueue = hmBuyQueue.get(s);
            sellQueue = hmSellQueue.get(s);
            if (sellQueue.isEmpty() || buyQueue.isEmpty())
                continue;

            buyOrder = buyQueue.poll();
            sellOrder = sellQueue.poll();
            while(buyOrder != null && sellOrder != null ) {
                if (buyOrder.getPrice() < sellOrder.getPrice()){
                    buyQueue.add(buyOrder);
                    sellQueue.add(sellOrder);
                    break;
                }

                transactionId = index.transactionId.getAndAdd(1);
                orderBuyId  = buyOrder.getIdOrder();
                orderSellId = sellOrder.getIdOrder();
                date        = new Date();
                stockCode   = buyOrder.getIDStock();
                amount      = Math.min(buyOrder.getAmount(), sellOrder.getAmount());
                price       = sellOrder.getPrice();

                Transaction transaction = new Transaction(transactionId, date, stockCode, orderBuyId, orderSellId,   amount, price);
                transactions.add(transaction);

                if (amount < buyOrder.getAmount()) {
                    buyOrder.setAmount(buyOrder.getAmount() - amount);
                    buyQueue.add(buyOrder);
                }
                else if (amount < sellOrder.getAmount()) {
                    sellOrder.setAmount(sellOrder.getAmount() - amount);
                    sellQueue.add(sellOrder);
                }

                System.out.println("Tạo thành công: " + transaction);
                buyOrder = buyQueue.poll();
                sellOrder = sellQueue.poll();
            }
        }
    }
}
