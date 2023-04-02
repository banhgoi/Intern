package buoi12.bai2;

public class Supplier {
    private String IdSup;
    private String Name;
    private String Address;
    private String Tel;

    public Supplier() {
    }

    public Supplier(String idSup) {
        IdSup = idSup;
    }

    public Supplier(String idSup, String name, String address, String tel) {
        IdSup = idSup;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public String getIdSup() {
        return IdSup;
    }

    public void setIdSup(String idSup) {
        IdSup = idSup;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    @Override
    public int hashCode() {
        return this.getIdSup().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getIdSup().equals(((Supplier) obj).getIdSup());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "IdSup='" + IdSup + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                '}';
    }
}
