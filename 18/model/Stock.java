package company.model;

import java.util.Date;

//Cổ phiếu niêm yết trên sàn
public class Stock {
    String idStock;
    String name;
    Integer amount;
    Integer price;
    String idCompany;
    Date daytime;

    public Stock(String idStock, String name, Integer amount, Integer price, String idCompany, Date daytime) {
        this.idStock = idStock;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.idCompany = idCompany;
        this.daytime = daytime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "idStock='" + idStock + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", idCompany='" + idCompany + '\'' +
                ", daytime=" + daytime +
                '}';
    }
}
