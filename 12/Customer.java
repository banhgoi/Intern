package buoi12.bai2;

public class Customer implements Comparable<Customer>{
    private String IdCus;
    private String Name;
    private String Address;
    private String Tel;

    public Customer() {
    }

    public Customer(String idCus) {
        IdCus = idCus;
    }

    public Customer(String idCus, String name, String address, String tel) {
        IdCus = idCus;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public String getIdCus() {
        return IdCus;
    }

    public void setIdCus(String idCus) {
        IdCus = idCus;
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
    public String toString() {
        return "Customer{" +
                "IdCus='" + IdCus + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.getIdCus().compareTo(o.getIdCus());
    }

    @Override
    public int hashCode() {
        return this.getIdCus().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getIdCus().equals(((Customer)obj).getIdCus());
    }
}
