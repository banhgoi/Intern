package buoi12.bai2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase implements Comparable<Purchase>{
    private Integer IdPurchase;
    private Date putDate;
    private String SupplierID;

    public Purchase() {
    }

    public Purchase(Integer idPurchase, Date putDate, String supplierID) {
        IdPurchase = idPurchase;
        this.putDate = putDate;
        SupplierID = supplierID;
    }

    public Integer getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        IdPurchase = idPurchase;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    @Override
    public int compareTo(Purchase o) {
        return this.getIdPurchase().compareTo(o.getIdPurchase());
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Purchase{" +
                "IdPurchase=" + IdPurchase +
                ", putDate=" + dateFormat.format(putDate) +
                ", SupplierID='" + SupplierID + '\'' +
                '}';
    }
}
