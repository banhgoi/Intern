package TH9.Mappppp.Bai2;

import java.io.Serializable;

public class Customer implements Serializable,Comparable<Customer> {
    private String IdCus;
    private String Name;
    private String Address;
    private String Tel;

    public Customer(String idCus, String name, String address, String tel) {
        IdCus = idCus;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public Customer() {
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
    public String toString(){
        return "Customer ("+IdCus+" "+Name+" "+Address+" "+Tel+")";
    }
    @Override
    public int compareTo(Customer o) {
        int i;
        return i = this.IdCus.compareTo(o.IdCus);
    }
}

