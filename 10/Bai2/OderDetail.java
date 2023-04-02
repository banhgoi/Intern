package TH9.Mappppp.Bai2;

public class OderDetail {
    private  int IdOder;
    private int IdDetail;
    private int ItemID;
    private int Amount;
    private float Price;

    public OderDetail(int idOder, int idDetail, int itemID, int amount, float price) {
        IdOder = idOder;
        IdDetail = idDetail;
        ItemID = itemID;
        Amount = amount;
        Price = price;
    }

    public OderDetail() {
    }

    public int getIdOder() {
        return IdOder;
    }

    public void setIdOder(int idOder) {
        IdOder = idOder;
    }

    public int getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(int idDetail) {
        IdDetail = idDetail;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }
    public String toString(){
        return "OderDetail ("+IdOder+" "+IdDetail+" "+ItemID+" "+Amount+" "+Price+")";
    }
}
