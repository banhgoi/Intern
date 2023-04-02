package project1;

import java.util.Date;

public class Order  implements Comparable<Order>{
    private String OrderID;
    private Date OrderDate;
    private String CustomerID;
    private String StockID;
    private Integer Amount;
    private Float Price;
    private String Type;

    public Order() {
    }

    public Order(String orderID, Date orderDate, String customerID, String stockID, Integer amount, Float price, String type) {
        OrderID = orderID;
        OrderDate = orderDate;
        CustomerID = customerID;
        StockID = stockID;
        Amount = amount;
        Price = price;
        Type = type;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getStockID() {
        return StockID;
    }

    public void setStockID(String stockID) {
        StockID = stockID;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID =" + OrderID +
                ", OrderDate =" + OrderDate +
                ", CustomerID ='" + CustomerID +
                ", Stock ='" + StockID +
                ", Amount ='" + Amount +
                ", Price ='" + Price +
                ", Type ='" + Type +
                '\'' +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return this.OrderDate.compareTo(o.getOrderDate());
    }
}
