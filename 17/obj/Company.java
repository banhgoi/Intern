package obj;

public class Company {
    String IDCompany;
    String Name;

    String Address;

    String Tel;

    public Company(String IDCompany, String name, String address, String tel) {
        this.IDCompany = IDCompany;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public String getIDCompany() {
        return IDCompany;
    }

    public void setIDCompany(String IDCompany) {
        this.IDCompany = IDCompany;
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
}
