package buoi12.bai2;

public class OrderDetail {
    private Integer IdOrder;
    private Integer IdDetail;
    private Integer ItemID;
    private Integer Amount;
    private Float Price;

    public OrderDetail() {
    }

    public OrderDetail(Integer idOrder, Integer idDetail, Integer itemID, Integer amount, Float price) {
        IdOrder = idOrder;
        IdDetail = idDetail;
        ItemID = itemID;
        Amount = amount;
        Price = price;
    }

    public Integer getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(Integer idOrder) {
        IdOrder = idOrder;
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

    @Override
    public String toString() {
        return "OrderDetail{" +
                "IdOrder=" + IdOrder +
                ", IdDetail=" + IdDetail +
                ", ItemID=" + ItemID +
                ", Amount=" + Amount +
                ", Price=" + Price +
                '}';
    }
}
