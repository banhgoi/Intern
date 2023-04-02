package stockexchange;

import java.util.*;

public class Transaction {
    private Integer id;
    private Integer orderBuyID;
    private Integer orderSellID;
    private Date date;
    private Integer buyID;
    private Integer sellID;
    private Integer stockID;
    private Integer amount;
    private Integer price;

    public Transaction(Integer id, Integer orderBuyID, Integer orderSellID, Date date, Integer buyID, Integer sellID, Integer stockID, Integer amount, Integer price) {
        this.id = id;
        this.orderBuyID = orderBuyID;
        this.orderSellID = orderSellID;
        this.date = date;
        this.buyID = buyID;
        this.sellID = sellID;
        this.stockID = stockID;
        this.amount = amount;
        this.price = price;
    }

    public Integer getID() {
        return id;
    }

    public Integer getOrderBuyID() {
        return orderBuyID;
    }

    public Integer getOrderSellID() {
        return orderSellID;
    }

    public Date getDate() {
        return date;
    }

    public Integer getBuyID() {
        return buyID;
    }

    public Integer getSellID() {
        return sellID;
    }

    public Integer getStockID() {
        return stockID;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Transaction {id = " + id +
                "; orderBuyID = " + orderBuyID +
                "; orderSellID = " + orderSellID +
                "; date = " + date +
                "; buyID = " + buyID +
                "; sellID = " + sellID +
                "; stockID = '" + stockID +
                "'; amount=" + amount +
                "; price = " + price +
                "}";
    }
}
