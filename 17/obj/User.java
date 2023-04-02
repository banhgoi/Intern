package obj;

public class User {
    String IdUser;
    String Name;

    String Address;

    String Tel;

    public User(String idUser, String name) {
        IdUser = idUser;
        Name = name;
        Address ="";
        Tel="";
    }

    public User(String idUser, String name, String address, String tel) {
        IdUser = idUser;
        Name = name;
        Address = address;
        Tel = tel;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
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
        return "User{" +
                "IdUser='" + IdUser + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                '}';
    }
}
