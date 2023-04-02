package stockexchange;

import java.util.*;

public class Order {
    private Integer id;
    private Date date;
    private Integer traderID;
    private Boolean type; //type = true -> buy
    private Integer stockID;
    private Integer amount;
    private Integer price;

    public Order(Integer id, Date date, Integer traderID, Boolean type, Integer stockID, Integer amount, Integer price) {
        setID(id);
        setDate(date);
        setTraderID(traderID);
        setType(type);
        setStockID(stockID);
        setAmount(amount);
        setPrice(price);
    }
    public void setID(Integer id)
    {
        this.id = id;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public void setTraderID(Integer traderID)
    {
        this.traderID = traderID;
    }
    public void setType(Boolean type)
    {
        this.type = type;
    }
    public void setStockID(Integer stockID)
    {
        this.stockID = stockID;
    }
    public Integer getID() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getTraderID() {
        return traderID;
    }

    public Boolean getType() {
        return type;
    }

    public Integer getStockID() {
        return stockID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order {id = " + id +
                "; date = " + date +
                "; traderID = " + traderID +
                "; type = " + type +
                "; stockID = '" + stockID +
                "'; amount = " + amount +
                "; price = " + price +
                "}";
    }
}
