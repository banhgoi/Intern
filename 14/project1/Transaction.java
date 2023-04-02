package project1;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable, Comparable<Transaction> {
    private String TransID;
    private Date TransDate;
    private String OrderSellID;
    private String CustomerID;
    private String StockID;

    public Transaction() {
    }

    public Transaction(String transID, Date transDate, String orderSellID, String customerID, String stockID) {
        TransID = transID;
        TransDate = transDate;
        OrderSellID = orderSellID;
        CustomerID = customerID;
        StockID = stockID;
    }

    public String getTransID() {
        return TransID;
    }

    public void setTransID(String transID) {
        TransID = transID;
    }

    public Date getTransDate() {
        return TransDate;
    }

    public void setTransDate(Date transDate) {
        TransDate = transDate;
    }

    public String getOrderSellID() {
        return OrderSellID;
    }

    public void setOrderSellID(String orderSellID) {
        OrderSellID = orderSellID;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "TransasctionID =" + TransID +
                ", TranDate =" + TransDate +
                ", StockID =" + StockID +
                ", OrderSellID =" + OrderSellID +
                ", CustomerID =" + CustomerID +
                '}';
    }
    @Override
    public int compareTo(Transaction o) {
        return this.TransID.compareTo(o.TransID);
    }
}
