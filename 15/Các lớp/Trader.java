package project1;

import java.util.*;

public class Trader extends User {
    private int money;
    private Map<Stock, Integer> stocks;
    private List<TradeOrder> action;

    public Trader(int money, Map<Stock, Integer> stocks, List<TradeOrder> action) {
        this.money = money;
        this.stocks = stocks;
        this.action = action;
    }

    public Trader(String name, String userID, Date dateOfBirth, String username, String password, String role, int money, Map<Stock, Integer> stocks, List<TradeOrder> action) {
        super(name, userID, dateOfBirth, username, password, role);
        this.money = money;
        this.stocks = stocks;
        this.action = action;
    }

    public int getMoney() {
        return money;
    }

    public Map<Stock, Integer> getStocks() {
        return stocks;
    }

    public List<TradeOrder> getAction() {
        return action;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setStocks(Map<Stock, Integer> stocks) {
        this.stocks = stocks;
    }

    public void setAction(List<TradeOrder> action) {
        this.action = action;
    }

    public void addStocks(Stock stock, int amount) {
        this.stocks.put(stock, amount);
    }

    public void addAction(String stockname, String action, int amount, int price) {
        this.action.add(new TradeOrder(stockname, action, amount, price));
    }


}