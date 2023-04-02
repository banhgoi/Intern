package obj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    int IdOrder;
    Date OrdDate;
    String IDTrader;
    String IDStock;
    int Amount;
    double Price;
    boolean Sale;

    public Order() {
    }

    public Order(int idOrder, String ordDate, String IDTrader) {
        IdOrder = idOrder;
        try {
            OrdDate = new SimpleDateFormat("dd/MM/yyyy").parse(ordDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.IDTrader = IDTrader;
    }

    public Order(int idOrder, String IDTrader, String IDStock, int amount, double price, boolean sale) {
        IdOrder = idOrder;
        this.IDTrader = IDTrader;
        this.IDStock = IDStock;
        Amount = amount;
        Price = price;
        Sale = sale;
    }

    public Order(int idOrder, String ordDate, String IDTrader, String IDStock, int amount, double price, boolean sale) {
        IdOrder = idOrder;
        try {
            OrdDate = new SimpleDateFormat("dd/MM/yyyy").parse(ordDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.IDTrader = IDTrader;
        this.IDStock = IDStock;
        Amount = amount;
        Price = price;
        Sale = sale;
    }

    @Override
    public String toString() {
        return "Order{" +
                "IdOrder=" + IdOrder +
                ", OrdDate=" + OrdDate +
                ", IDTrader='" + IDTrader + '\'' +
                ", IDStock='" + IDStock + '\'' +
                ", Amount=" + Amount +
                ", Price=" + Price +
                ", Sale=" + Sale +
                '}';
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(Date ordDate) {
        OrdDate = ordDate;
    }

    public String getIDTrader() {
        return IDTrader;
    }

    public void setIDTrader(String IDTrader) {
        this.IDTrader = IDTrader;
    }

    public String getIDStock() {
        return IDStock;
    }

    public void setIDStock(String IDStock) {
        this.IDStock = IDStock;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isSale() {
        return Sale;
    }

    public void setSale(boolean sale) {
        Sale = sale;
    }
}
