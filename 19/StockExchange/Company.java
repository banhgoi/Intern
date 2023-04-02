package stockexchange;

public class Company {
    private Integer id;
    private String name;
    private String address;
    private String email;

    public Company(Integer id, String name, String address, String email) {
        setID(id);
        setName(name);
        setAddress(address);
        setEmail(email);
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
