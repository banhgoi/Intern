package obj;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    String IDUser;
    String IDTrader;
    Double Balance;
Map<Stock,Integer> stockList=new HashMap<>();

    public Trader(String IDTrader) {
        this.IDTrader = IDTrader;
    }

    public Trader(String IDUser, String IDTrader, Double balance) {
        this.IDUser = IDUser;
        this.IDTrader = IDTrader;
        Balance = balance;
    }

    public Trader(String IDUser, String IDTrader, Double balance, Map<Stock, Integer> stockList) {
        this.IDUser = IDUser;
        this.IDTrader = IDTrader;
        Balance = balance;
        this.stockList = stockList;
    }

    public String getIDUser() {
        return IDUser;
    }

    public void setIDUser(String IDUser) {
        this.IDUser = IDUser;
    }

    public String getIDTrader() {
        return IDTrader;
    }

    public void setIDTrader(String IDTrader) {
        this.IDTrader = IDTrader;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }
}
