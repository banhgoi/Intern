package obj;

public class Stock {
    String IDStock;
    String IDcompany;
    String Name;

    public Stock() {
    }

    public Stock(String IDStock) {
        this.IDStock = IDStock;
    }

    public Stock(String IDStock, String IDcompany, String name) {
        this.IDStock = IDStock;
        this.IDcompany = IDcompany;
        Name = name;

    }

    public String getIDStock() {
        return IDStock;
    }

    public void setIDStock(String IDStock) {
        this.IDStock = IDStock;
    }

    public String getIDcompany() {
        return IDcompany;
    }

    public void setIDcompany(String IDcompany) {
        this.IDcompany = IDcompany;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "IDStock='" + IDStock + '\'' +
                ", IDcompany='" + IDcompany + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
