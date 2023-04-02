package project1;

import java.io.Serializable;

public class TradeOrder implements Serializable,Comparable<TradeOrder> {
    private String Stockname;
    private String Action;
    private int Amount;
    private int price;

    public TradeOrder(String stockname, String action, int amount, int price) {
        Stockname = stockname;
        Action = action;
        this.Amount = amount;
        this.price = price;
    }

    public String getStockname() {
        return Stockname;
    }

    public String getAction() {
        return Action;
    }

    public int getAmount() {
        return Amount;
    }

    public int getPrice() {
        return price;
    }

    public void setStockname(String stockname) {
        Stockname = stockname;
    }

    public void setAction(String action) {
        Action = action;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TradeOrder{" +
                "Stockname='" + Stockname + '\'' +
                ", Action='" + Action + '\'' +
                ", amount=" + Amount +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(TradeOrder o) {
        return this.price - o.getPrice();
    }
}