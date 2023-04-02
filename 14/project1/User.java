package project1;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable, Comparable {
    private String Name;
    private String UserID;
    private Date DateOfBirth;
    private String Username;
    private String Password;
    private String Role;

    public User() {
    }

    public User(String name, String userID, Date dateOfBirth, String username, String password, String role) {
        Name = name;
        UserID = userID;
        DateOfBirth = dateOfBirth;
        Username = username;
        Password = password;
        Role = role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public int hashCode() {
        return (Integer.valueOf(this.UserID.substring(3)) % 50);
    }

    @Override
    public boolean equals(Object obj) {
        String s = ((User) obj).getUserID();
        return this.UserID.equals(s);
    }

    @Override
    public int compareTo(Object o) {
        String s = ((User) o).getUserID();
        return this.UserID.compareTo(s);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + Name + '\'' + ", traderID='" + UserID + '\'' +
                ", dateOfBirth=" + DateOfBirth +
                ", username='" + Username + '\'' +
                ", password='" + Password + '\'' +
                '}';
    }
}