package TH9.Mappppp.Bai2;

public class Supplier {
    private String IdSup;
    private String Name;
    private String Address;
    private String Tel;

    public Supplier() {
    }

    public Supplier(String idSup, String name, String address, String tel) {
        IdSup = idSup;
        this.Name = Name;
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

    public String toString(){
        return "Supplier ("+IdSup+" "+Name+" "+Address+" "+Tel+")";
    }
}
