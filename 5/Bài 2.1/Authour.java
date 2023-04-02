package OOP;

public class Authour {
    private String name;
    private String email;
    private String gender;
    private int age;

    public Authour(String name, String email, String gender, int age) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String toString() {
        String a ="  "+ this.getName() + ", Email: "+ this.getEmail() + ", Gender: " + this.getGender();
        return a;
    }
}
