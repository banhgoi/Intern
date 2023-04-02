package TH9.Mappppp.Bai2;

import java.io.Serializable;
import java.util.Date;

public class Oder implements Serializable, Comparable<Oder> {
    private int IdOder;
    private Date OrdDate;
    private String CustomerID;

    public Oder(int idOder, Date ordDate, String customerID) {
        IdOder = idOder;
        OrdDate = ordDate;
        CustomerID = customerID;
    }

    public Oder() {
    }

    public Oder(int id) {
        this.IdOder =id;
    }


    public int getIdOder() {
        return IdOder;
    }

    public void setIdOder(int idOder) {
        IdOder = idOder;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(Date ordDate) {
        OrdDate = ordDate;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }
    public String toString(){
        return "\nOder ("+IdOder+" "+OrdDate+" "+CustomerID+")";
    }

    @Override
    public int compareTo(Oder o) {
        int i = ((Oder) o).getIdOder();
        return this.IdOder - i;
    }
}
