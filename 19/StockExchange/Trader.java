package stockexchange;

import java.util.*;

public class Trader extends User implements Comparable<Trader> {
    private Integer balance;
    private Map<String, Integer> stocksAvailable;

    public Trader(Integer id, String fullname, String email, String phone) {
        super(id, fullname, email, phone);
        balance = 0;
        stocksAvailable = new HashMap<>();
    }

    public Trader(Integer id, String fullname, String email, String phone, Integer balance) {
        super(id, fullname, email, phone);
        this.balance = balance;
        stocksAvailable = new HashMap<>();
    }

    public Trader(Integer id, String fullname, String email, String phone, Integer balance, Map<String, Integer> stocksAvailable) {
        super(id, fullname, email, phone);
        this.balance = balance;
        this.stocksAvailable = stocksAvailable;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Map<String, Integer> getStocksAvailable() {
        return stocksAvailable;
    }

    public void setStocksAvailable(Map<String, Integer> stocksAvailable) {
        this.stocksAvailable = stocksAvailable;
    }

    @Override
    public int compareTo(Trader o) {
        return this.getID().compareTo(o.getID());
    }
}
