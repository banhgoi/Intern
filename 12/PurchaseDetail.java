package buoi12.bai2;

public class PurchaseDetail {
    private Integer IdPurchase;
    private Integer IdDetail;
    private Integer ItemID;
    private Integer Amount;
    private Float Price;

    public PurchaseDetail() {
    }

    public PurchaseDetail(Integer idPurchase, Integer idDetail, Integer itemID, Integer amount, Float price) {
        IdPurchase = idPurchase;
        IdDetail = idDetail;
        ItemID = itemID;
        Amount = amount;
        Price = price;
    }

    public Integer getIdPurchase() {
        return IdPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        IdPurchase = idPurchase;
    }

    public Integer getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(Integer idDetail) {
        IdDetail = idDetail;
    }

    public Integer getItemID() {
        return ItemID;
    }

    public void setItemID(Integer itemID) {
        ItemID = itemID;
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
}
