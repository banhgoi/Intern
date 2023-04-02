package project1;

import java.io.Serializable;

public class Stock implements Serializable, Comparable {
    private Company company;
    private String name;
    private int price;

    public Stock() {
    }

    public Stock(Company company, String name, int price) {
        this.company = company;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }

    @Override
    public boolean equals(Object obj) {
        String s = ((Stock) obj).getName();
        return this.name.equals(s);
    }

    @Override
    public int compareTo(Object o) {
        String s = ((Stock) o).getName();
        return this.name.compareTo(s);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "company=" + company +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}