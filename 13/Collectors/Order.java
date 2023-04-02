package buoi12.bai2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Comparable<Order>{
    private Integer IdOrder;
    private Date OreDate;
    private String CustomerID;

    public Order() {
    }

    public Order(Integer idOrder) {
        IdOrder = idOrder;
    }

    public Order(Integer idOrder, Date oreDate, String customerID) {
        IdOrder = idOrder;
        OreDate = oreDate;
        CustomerID = customerID;
    }

    public Integer getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(Integer idOrder) {
        IdOrder = idOrder;
    }

    public Date getOreDate() {
        return OreDate;
    }

    public void setOreDate(Date oreDate) {
        OreDate = oreDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    @Override
    public int compareTo(Order o) {
        return this.getIdOrder().compareTo(o.getIdOrder());
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Order{" +
                "IdOrder=" + IdOrder +
                ", OreDate=" + dateFormat.format(OreDate) +
                ", CustomerID='" + CustomerID + '\'' +
                '}';
    }
}
