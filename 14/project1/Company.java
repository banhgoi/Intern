package project1;

import java.io.Serializable;

public class Company implements Serializable, Comparable {
    private String ComID;
    private String name;

    public Company(String comID, String name) {
        ComID = comID;
        this.name = name;
    }

    public Company() {
    }

    public String getComID() {
        return ComID;
    }

    public void setComID(String comID) {
        ComID = comID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }

    @Override
    public boolean equals(Object obj) {
        String s = ((Company) obj).getComID();
        return this.ComID.equals(s);
    }

    @Override
    public int compareTo(Object o) {
        String s = ((Company) o).getComID();
        return this.ComID.compareTo(s);
    }
}