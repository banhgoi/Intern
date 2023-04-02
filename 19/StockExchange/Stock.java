package stockexchange;

import java.util.*;

public class Stock{
    private Integer priceID;
    private Integer code;
    private Integer idCompany;
    private String nameCompany;
    private Integer minPrice;
    private Integer maxPrice;

    public Stock(Integer priceID, Integer code, Integer idCompany, String nameCompany, Integer minPrice, Integer maxPrice) {
        setPriceID(priceID);
        setCode(code);
        setCompanyID(idCompany);
        setNameCompany(nameCompany);
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);
    }

    public Integer getPriceID() {
        return priceID;
    }

    public void setPriceID(Integer priceID) {
        this.priceID = priceID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCompanyID() {
        return idCompany;
    }

    public void setCompanyID(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(code, stock.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Stock {priceID = " + priceID +
                "; code = '" + code +
                "'; idCompany = " + idCompany +
                "; nameCompany = '" + nameCompany +
                "'; minPrice = " + minPrice +
                "; maxPrice = " + maxPrice +
                "}";
    }
}
