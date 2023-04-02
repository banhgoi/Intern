package OOP;

public class Address {
    public String country;
    public String city;
    public String district;
    public String street;

    public Address(String country, String city, String district, String street) {
        this.country = country;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String toString() {
        String a =this.getStreet()+ ", " + this.getDistrict()+ ", "+ this.getCity()+", Country: "+ this.getCountry();
        return a;
    }
}
