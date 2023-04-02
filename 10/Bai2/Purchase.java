package TH9.Mappppp.Bai2;

import java.util.Date;

public class Purchase {
    private int IdPurchase;
    private Date purDate;
    private String SupplierID;

    public Purchase(int idPurchase, Date purDate, String supplierID) {
        IdPurchase = idPurchase;
        this.purDate = purDate;
        SupplierID = supplierID;
    }

    public Purchase() {
    }

    public int getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        IdPurchase = idPurchase;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }
    public String toString(){
        return "Purchase ("+IdPurchase+" "+purDate+" "+SupplierID+")";
    }
}
