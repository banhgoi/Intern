package stockexchange;

public class User {
    private Integer id;
    private String fullname;
    private String email;
    private String phone;

    public User() {
    }

    public User(Integer id, String fullname, String email, String phone) {
        setID(id);
        setFullname(fullname);
        setEmail(email);
        setPhone(phone);
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User {id = '" + id +
                "'; fullname = '" + fullname +
                "'; email = '" + email +
                "'; phone = '" + phone +
                "'}";
    }
}
