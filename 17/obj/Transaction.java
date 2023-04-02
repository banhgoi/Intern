package obj;

import java.util.Date;

public class Transaction {
    int IDTrans;
    Date TransDate;
    String IDStock;
    int IDOrderMua;
    int IDOrderBan;
    int Amount;
    double Price;

    public Transaction(int IDTrans, Date transDate, String IDStock, int IDOrderMua, int IDOrderBan, int amount, double price) {
        this.IDTrans = IDTrans;
        TransDate = transDate;
        this.IDStock = IDStock;
        this.IDOrderMua = IDOrderMua;
        this.IDOrderBan = IDOrderBan;
        Amount = amount;
        Price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "IDTrans=" + IDTrans +
                ", TransDate=" + TransDate +
                ", IDStock='" + IDStock + '\'' +
                ", IDOrderMua='" + IDOrderMua + '\'' +
                ", IDOrderBan='" + IDOrderBan + '\'' +
                ", Amount=" + Amount +
                ", Price=" + Price +
                '}';
    }
}
